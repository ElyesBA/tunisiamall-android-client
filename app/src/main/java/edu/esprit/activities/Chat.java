package edu.esprit.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import edu.esprit.adapters.ChatAdapter;
import edu.esprit.delegates.MessageDelegate;
import edu.esprit.entities.Message;
import edu.esprit.entities.User;

public class Chat extends AppCompatActivity {

    private TextView chatUsername;
    private EditText messageET;
    private ListView messagesContainer;
    private Button sendBtn;
    private ChatAdapter adapter;
    private ArrayList<Message> chatHistory;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        user = getIntent().getParcelableExtra("User");
        initControls();
    }

    private void initControls() {
        chatUsername = (TextView) findViewById(R.id.chat_username);
        messagesContainer = (ListView) findViewById(R.id.messagesContainer);
        messageET = (EditText) findViewById(R.id.messageEdit);
        sendBtn = (Button) findViewById(R.id.chatSendButton);

        chatUsername.setText(user.getFirstName());
        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
        loadDummyHistory();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageET.getText().toString();
                if (TextUtils.isEmpty(messageText)) {
                    return;
                }

                Message chatMessage = new Message();
                chatMessage.setText(messageText);
                chatMessage.setDate(new Date());
                chatMessage.setMe(1);

                messageET.setText("");

                displayMessage(chatMessage);
            }
        });
    }

    public void displayMessage(Message message) {
        adapter.add(message);
        adapter.notifyDataSetChanged();
        scroll();
    }

    private void scroll() {
        messagesContainer.setSelection(messagesContainer.getCount() - 1);
    }

    private void loadDummyHistory() {

        chatHistory = MessageDelegate.getChat();
        adapter = new ChatAdapter(Chat.this, new ArrayList<Message>());
        messagesContainer.setAdapter(adapter);

        for (int i = 0; i < chatHistory.size(); i++) {
            Message message = chatHistory.get(i);
            displayMessage(message);
        }
    }
}
