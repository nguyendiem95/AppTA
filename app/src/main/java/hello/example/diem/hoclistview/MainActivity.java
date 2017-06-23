package hello.example.diem.hoclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lstmonhoc;
    String [] arr ={"LS1","LS2","LS3"};
    ArrayAdapter<String> app ;
    ArrayList<String> dsmonhoc = new ArrayList<>();
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrol();
        app = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,dsmonhoc);
        lstmonhoc.setAdapter(app);
        lstmonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String mss = "Bạn đang click vào môn"+dsmonhoc.get(position);
                        Toast.makeText(MainActivity.this,mss,Toast.LENGTH_LONG).show();
                    }
                });
        lstmonhoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dsmonhoc.remove(position);
                app.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void addcontrol() {
        lstmonhoc =(ListView)findViewById(R.id.lstmonhoc);
        button =(Button)findViewById(R.id.button);
        editText =(EditText)findViewById(R.id.editText3);
    }

    public void addmonhoc(View view){
        String tenmon = editText.getText().toString();
        dsmonhoc.add(tenmon);
        app.notifyDataSetChanged();
        editText.setText("");
    }
}
