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
        import java.util.Date;
        import java.util.Objects;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.firebase.ui.auth.AuthUI;

        import static ca.uottawa.tophillhotelmanagement.Priority.HIGH;
        import static ca.uottawa.tophillhotelmanagement.Priority.LOW;
        import static ca.uottawa.tophillhotelmanagement.Priority.NORMAL;

public class LoadActivity extends AppCompatActivity {

    //Atrem's Test Code
    //Task newTask = Task();

    //Firebase staff is here
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static int RC_SIGN_IN = 1;//login status
    public final String ANONYMUS = "ANANIMUS";
    private String mUsername = ANONYMUS;

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
                    } else if (Objects.equals(user.getEmail(), "receptionist@tophill.ca")) {
                        Intent launchNewIntent = new Intent(LoadActivity.this, ReceptionistActivity.class);
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


        //Variables created to pass to the singleton Dataset (not used globally).
        ArrayList<Personnel> staffList ;
        HotelManager hotelManager;
        Manager manager;
        Department currentDepartment;

        //Omar's data creation
        ArrayList <Department> departments = new ArrayList<>();
        hotelManager = new HotelManager("John Boss","admin@tophill.ca",-1,departments);
        Department cleaningDept = new CleaningDept("Cleaning Department",null);
        departments.add(cleaningDept);
        hotelManager.createEmployee("John Manager","manager@tophill.ca","Cleaning Department","Manager", -1);
        manager=cleaningDept.manager();
        currentDepartment = cleaningDept;
        currentDepartment.CreateTasks();
        //creating employees
        hotelManager.createEmployee("Artem the Boss","artem_boss@tophill.ca","Cleaning Department","Employee", R.drawable.boss);
        hotelManager.createEmployee("Beyonce Knowles","bknowles@tophill.ca","Cleaning Department","Employee", R.drawable.taha);
        hotelManager.createEmployee("Brad Pitt","bpitt@tophill.ca","Cleaning Department","Employee",R.drawable.bard);
        hotelManager.createEmployee("Alex","axe@tophill.ca","Cleaning Department","Employee",R.drawable.al);
        hotelManager.createEmployee("Omar","calmar@tophill.ca","Cleaning Department","Employee",R.drawable.om);
        hotelManager.createEmployee("George Clooney","gcloney@tophill.ca","Cleaning Department","Employee", -1);
        hotelManager.createEmployee("Kevin Hart","khart@tophill.ca","Cleaning Department","Employee", -1);
        hotelManager.createEmployee("Kim Kardashian","kkardashian@tophill.ca","Cleaning Department","Employee", -1);
        hotelManager.createEmployee("Leonardo DiCaprio","ldicaprio@tophill.ca","Cleaning Department","Employee", -1);
        hotelManager.createEmployee("Taylor Swift","tswift@tophill.ca","Cleaning Department","Employee", -1);
        hotelManager.createEmployee("Tom Hanks","thanks@tophill.ca","Cleaning Department","Employee", -1);
        hotelManager.createEmployee("Will Ferrell","wferrell@tophill.ca","Cleaning Department","Employee", -1);
        staffList = hotelManager.staff;

        Task t1 = new Task("Managers Meeting", HIGH, new Date(2017,12,7,5,30),manager);
        manager.addTask(t1);
        Task t2 = new Task("Department Report", HIGH, new Date(2017,12,12,10,0),manager);
        manager.addTask(t2);
        Task t3 = new Task("Staff Meeting", LOW, new Date(2017,12,15,10,0),manager);
        manager.addTask(t3);
        Task t4 = new Task("Meeting with VIP guest", HIGH, new Date(2017,12,20,2,0),manager);
        manager.addTask(t4);
        Task t5 = new Task("Hiring session", NORMAL, new Date(2017,12,29,10,0),manager);
        manager.addTask(t5);
        Task t6 = new Task("Buying department supplies", NORMAL, new Date(2018,1,6,8,0),manager);
        manager.addTask(t6);
        Task t7 = new Task("Managers Meeting", HIGH, new Date(2018,2,19,5,30),manager);
        manager.addTask(t7);
        Task t9 = new Task("Demo task", HIGH, new Date(2018,2,19,5,30),manager);
        manager.addTask(t9);
        Task t10 = new Task("Demo task", HIGH, new Date(2018,2,19,5,30),manager);
        manager.addTask(t10);
        Task t11 = new Task("Demo task", HIGH, new Date(2018,2,19,5,30),manager);
        manager.addTask(t11);

        //
        ((Dataset) this.getApplication()).setHotelManager(hotelManager);
        ((Dataset) this.getApplication()).setStaffList(staffList);
        ((Dataset) this.getApplication()).setCurrentDepartment(currentDepartment);
        ((Dataset) this.getApplication()).setManager(manager);

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

                //mFirebaseAuth.signOut();

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
