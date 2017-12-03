package ca.uottawa.tophillhotelmanagement;

        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;
        import android.view.MenuItem;
        import android.widget.Toolbar;

        import java.util.Arrays;
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.LinkedList;
        import java.util.Objects;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.firebase.ui.auth.AuthUI;

public class LoadActivity extends AppCompatActivity {

    //Atrem's Test Code
    //Task newTask = Task();

    //Firebase staff is here
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static int RC_SIGN_IN = 1;//login status
    public final String ANONYMUS = "ANANIMUS";
    private String mUsername = ANONYMUS;


    public static LinkedList<Personnel> staffList ;
    public static HotelManager hotelManager;
    public static Manager manager;
    public static Department currentDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);


        //initialize Firebase staff
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                //check if logined in
                if (user != null) {
                    //user is signed in
                    // Toast.makeText(MainActivity.this, "You are now signed in.", Toast.LENGTH_SHORT).show();
                    onSignedInInitialize(user.getDisplayName());

                    if (Objects.equals(user.getEmail(), "admin@tophill.ca")) {
                        Intent launchNewIntent = new Intent(LoadActivity.this,HotelManagerActivity.class);
                        startActivityForResult(launchNewIntent, 0);
                    } else if (Objects.equals(user.getEmail(), "manager@tophill.ca")) {
                        Intent launchNewIntent = new Intent(LoadActivity.this, MainActivity.class);
                        startActivityForResult(launchNewIntent, 0);
                    }

                } else {
                    //user is not sighned out
                    onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)//log in every time
                                    .setAvailableProviders(
                                            Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                                    new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                                    .build(),
                            RC_SIGN_IN);
                }

            }
        };

        ArrayList <Department> departments = new ArrayList<>();
        hotelManager = new HotelManager("John Boss","admin@tophill.ca",-1,departments);

        Department cleaningDept = new CleaningDept("Cleaning Department",null);
        departments.add(cleaningDept);


        hotelManager.createEmployee("John Manager","manager@tophill.ca","Cleaning Department","Manager");
        //Iterator<Personnel> itr = staffList.iterator();
        manager=cleaningDept.manager();
        currentDepartment = cleaningDept;


        //creating employees
        hotelManager.createEmployee("Beyonce Knowles","bknowles@tophill.ca","Cleaning Department","Employee");
        hotelManager.createEmployee("Brad Pitt","bpitt@tophill.ca","Cleaning Department","Employee");
        hotelManager.createEmployee("George Clooney","gcloney@tophill.ca","Cleaning Department","Employee");
        hotelManager.createEmployee("Kevin Hart","khart@tophill.ca","Cleaning Department","Employee");
        hotelManager.createEmployee("Kim Kardashian","kkardashian@tophill.ca","Cleaning Department","Employee");
        hotelManager.createEmployee("Leonardo DiCaprio","ldicaprio@tophill.ca","Cleaning Department","Employee");
        hotelManager.createEmployee("Taylor Swift","tswift@tophill.ca","Cleaning Department","Employee");
        hotelManager.createEmployee("Tom Hanks","thanks@tophill.ca","Cleaning Department","Employee");
        hotelManager.createEmployee("Will Ferrell","wferrell@tophill.ca","Cleaning Department","Employee");
        staffList = hotelManager.staff;

    }
    //dealing with canceling during singing
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                // Sign-in succeeded, set up the UI
                Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                // Sign in was canceled by the user, finish the activity
                Toast.makeText(this, "Sign in canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                AuthUI.getInstance().signOut(this);
                mFirebaseAuth.signOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        //      return super.onOptionsItemSelected(item);
    }

    //adding and removing listener if activity is on the background
    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);

    }

    private void onSignedInInitialize(String user) {
        mUsername = user;
        //Build of main activity starts here
    }

    private void onSignedOutCleanup() {
        mUsername = ANONYMUS;
        //destruction before loging out
    }

}
