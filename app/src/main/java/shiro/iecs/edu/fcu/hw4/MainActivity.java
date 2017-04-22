package shiro.iecs.edu.fcu.hw4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.Mtoolbar);
        setSupportActionBar(toolbar);


        Button sentOutBtn = (Button) findViewById(R.id.SendOutBtn);
        sentOutBtn.setOnClickListener(btnSendOnClick);
    }

    private View.OnClickListener btnSendOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction("shiro.android.MY_BROADCAST");//自己定義的 Action ,不跟其他app重複

            //拿取 框框的的 字串
            final EditText senderText = (EditText) findViewById(R.id.Etext);
            String msg = senderText.getEditableText().toString();

            //放入intent 並送出,也可用 Bundle 包裹
            intent.putExtra("TEXT_KEY", msg);
            sendBroadcast(intent);
        }
    };
    //<內部資料準備>
    //拿資料喔~~~
         /*   final EditText senderText = (EditText) findViewById(R.id.Etext);
            String strings = new String(senderText.getText().toString()) ;

            //可以先把資料 放入 Bundle
            //再將此物件存入 intent
            Bundle bundle = new Bundle();
            bundle.putString("string_data",strings);//"string_data" 資料項目名稱

            //包裹好了   Broadcast Intent 送出廣播
            //設定此 廣播訊息 需要獨一無二 所以用程式套件路徑命名
            Intent it = new Intent("shiro.android.MY_BROADCAST");

            it.putExtras( bundle ); //放入包裹寫法
            //it.putExtra("type","資料附訊息"); 訊息質些放入 不包起來

            sendBroadcast(it); //呼叫 sendBroadcast() 方法廣播 intent 物件

            //跟User 說明已經廣播
            Toast.makeText(MainActivity.this, "已送出訊息~~ " ,
                    Toast.LENGTH_SHORT).show();

            /*Intent jumpMyintent = getPackageManager()       //開啟我的Reciver App "以下是APPID"
                           .getLaunchIntentForPackage("shiro.iecs.edu.fcu.receiver");
            startActivity(jumpMyintent);*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
