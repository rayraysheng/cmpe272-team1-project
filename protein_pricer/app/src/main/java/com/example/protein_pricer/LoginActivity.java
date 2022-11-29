package com.example.protein_pricer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.protein_pricer.Models.Users;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    Button signin;
    Button skip;
    private GoogleSignInClient client;
    FirebaseAuth auth;
    FirebaseDatabase database;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signin = findViewById(R.id.signin_button);
        skip = findViewById(R.id.skip_button);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance("https://protien-pricer-default-rtdb.firebaseio.com/");
        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        client = GoogleSignIn.getClient(this,options);
        client.revokeAccess();

        // Assign button functions
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = client.getSignInIntent();
                startActivityForResult(i, 123);

            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skip = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(skip);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
                auth.signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        if (task.isSuccessful()) {
                            LoginStatus.getInstance().login();
                            FirebaseUser user = auth.getCurrentUser();
                            Users users1 = new Users();
                            assert user != null;
                            users1.setUserId(user.getUid());
                            users1.setUserName(user.getDisplayName());
                            users1.setProfilePic(user.getPhotoUrl().toString());
                            database.getReference().child("users").child(user.getUid()).setValue(users1);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra( "userName",user.getDisplayName());
                            intent.putExtra("ProfilePic",user.getPhotoUrl().toString());
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                });

            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
    }
}