package com.codepath.todotodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        // Read item string from the main activity and set cursor to the end.
        String itemString = getIntent().getStringExtra("edit_item");
        EditText editItem = (EditText) findViewById(R.id.editText);
        editItem.setText(itemString);
        editItem.setSelection(editItem.getText().length());
    }

    // When the SAVE button is clicked, returned the updated string to main activity.
    public void onSubmit(View v) {
        EditText etName = (EditText) findViewById(R.id.editText);
        Intent data = new Intent();
        // Pass updated item as a result
        data.putExtra("updated_item", etName.getText().toString());
        // Pass the position back to the main activity.
        int pos = getIntent().getIntExtra("position", 0);
        data.putExtra("position", pos);
        // Activity finished ok, return the data
        setResult(RESULT_OK, data);
        finish(); // closes the activity, pass data to parent
    }
}
