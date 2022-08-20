package mx.unam.pentagrama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AppForm extends AppCompatActivity {

    private TextInputLayout tiName;
    private EditText etEmail;
    private TextInputLayout tiMessage;
    private Button button;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_form);
        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tiName    = findViewById(R.id.tiName);
        etEmail   = findViewById(R.id.etEmail);
        tiMessage = findViewById(R.id.tiMessage);
        button    = findViewById(R.id.button);

        // Sender email credential
        username = "didier.ominguez@gmail.com";
        password = "aliersgs7e";

        button.setOnClickListener(v -> {
            // Initialize properties
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", true);
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            // Initialize session
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                // Initialize email content
                Message message = new MimeMessage(session);
                // Sender email
                message.setFrom(new InternetAddress(username));
                // Recipient email
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(etEmail.getText().toString().trim()));
                // Email subject
                message.setSubject(tiName.getEditText().toString().trim());
                // Email message
                message.setText(tiMessage.getEditText().toString().trim());

                // Send email
                new SendMail().execute(message);

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });

    }

    private class SendMail extends AsyncTask<Message,String,String> {

        // Initialize progress dialog
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create and show progress dialog
            progressDialog.show(AppForm.this, "Please wait", "Sendindg Mail...", true, false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                // When success
                Transport.send(messages[0]);
                return "Success";
            } catch (MessagingException e) {
                // When error
                e.printStackTrace();
                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // Dismiss progress dialog
            progressDialog.dismiss();
            if (s.equals("Success")) {
                // When Success

                // Initialize aler dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(AppForm.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Success</font>"));
                builder.setMessage("Mail send successfully");
                builder.setPositiveButton("OK", ((dialog, which) -> {
                    dialog.dismiss();
                    // Clear all edit text
                    etEmail.setText("");
                    tiName.getEditText().setText("");
                    tiMessage.getEditText().setText("");
                }));
                builder.show();
            } else {
                // When error
                Toast.makeText(getApplicationContext(),
                        "Something went wrong ?", Toast.LENGTH_SHORT).show();
            }
        }
    }

}