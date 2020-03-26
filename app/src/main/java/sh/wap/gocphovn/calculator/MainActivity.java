package sh.wap.gocphovn.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewResult, textViewLog;
    Button btnZer, btnOne, btnTwo, btnThr, btnFou, btnFiv, btnSix, btnSev, btnEig, btnNin;
    Button btnAdd, btnSub, btnMul, btnDiv, btnC, btnCe, btnBs, btnSqu, btnDot, btnRev;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);
        textViewLog = findViewById(R.id.text_view_log);
        btnZer = (Button) findViewById(R.id.btn_rez);
        btnTwo = (Button) findViewById(R.id.btn_two);
        btnThr = (Button) findViewById(R.id.btn_thr);
        btnFou = (Button) findViewById(R.id.btn_fou);
        btnFiv = (Button) findViewById(R.id.btn_fiv);
        btnSix = (Button) findViewById(R.id.btn_six);
        btnSev = (Button) findViewById(R.id.btn_sev);
        btnEig = (Button) findViewById(R.id.btn_eig);
        btnNin = (Button) findViewById(R.id.btn_nin);
        btnOne = (Button) findViewById(R.id.btn_one);
        btnBs = (Button) findViewById(R.id.btn_bs);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnSub = (Button) findViewById(R.id.btn_sub);
        btnMul = (Button) findViewById(R.id.btn_mul);
        btnDiv = (Button) findViewById(R.id.btn_div);
        btnC = (Button) findViewById(R.id.btn_c);
        btnCe = (Button) findViewById(R.id.btn_ce);
        btnSqu = (Button) findViewById(R.id.btn_squ);
        btnDot = (Button) findViewById(R.id.btn_dot);
        btnRev = (Button) findViewById(R.id.btn_rev);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThr.setOnClickListener(this);
        btnFou.setOnClickListener(this);
        btnFiv.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSev.setOnClickListener(this);
        btnEig.setOnClickListener(this);
        btnNin.setOnClickListener(this);
        btnZer.setOnClickListener(this);
        btnBs.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnCe.setOnClickListener(this);
        btnSqu.setOnClickListener(this);
        btnRev.setOnClickListener(this);
        btnDot.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        Button btnTmp = (Button) v;

        switch (btnTmp.getText().toString()) {

            case "+":
            case "-":
            case "*":
            case "/":
                if(textViewLog.getText().toString().equals("")) {
                    textViewLog.setText(textViewResult.getText().toString() + " " + btnTmp.getText().toString());
                    textViewResult.setText("0");
                }
                break;
            case "=":
                String a = textViewResult.getText().toString();
                String tmp = textViewLog.getText().toString();
                if(tmp.equals("")) break;
                String b = tmp.substring(0, tmp.length()-2);
                String c = tmp.substring(tmp.length()-1);
                if(!textViewLog.getText().toString().equals("")) {
                    operator(a, b, c);
                }
                break;
            case "CE":
                textViewResult.setText("0");
                break;
            case "C":
                textViewResult.setText("0");
                textViewLog.setText("");
                break;
            case "BS":
                textViewResult.setText(textViewResult.getText().toString().substring(0, textViewResult.getText().toString().length()-1));
                if(textViewResult.getText().toString().equals(""))
                    textViewResult.setText("0");
                if(textViewResult.getText().toString().equals("0") && !textViewLog.getText().toString().equals("")) {
                    textViewResult.setText(textViewLog.getText().toString().substring(0, textViewLog.getText().toString().length()-2));
                    textViewLog.setText("");
                }
                break;
            case "+/-": break;
            case ".": break;
            default:
                if(textViewResult.getText().toString().length() == 9) return;
                if(textViewResult.getText().toString().equals("0")) {
                    textViewResult.setText(btnTmp.getText().toString());
                } else {
                    textViewResult.setText(textViewResult.getText().toString()+btnTmp.getText().toString());
                };
        }
    }
    public void operator(String a, String b, String c) {
        int tmpA = Integer.parseInt(a);
        int tmpB = Integer.parseInt(b);
        int result = 0;
        if(c.equals("+")) {
            result = tmpB + tmpA;
        } else if(c.equals("-")) {
            result = tmpB - tmpA;
        } else if(c.equals("*")) {
            result = tmpB * tmpA;
        } else if(c.equals("/")) {
            if(tmpA == 0) return;
            result = tmpB / tmpA;
        } else {
            return;
        }
        textViewResult.setText(String.valueOf(result));
        textViewLog.setText("");
    }
}
