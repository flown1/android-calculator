package com.example.a202258.myapp1;

import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.a202258.myapp1.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_c,
                    btn_back, btn_sign, btn_div, btn_multi, btn_sub, btn_add, btn_dot, btn_eq;
    private TextView display;
    private double sum = 0;
    private boolean firstInput = true;
    private boolean clearOnInput = false;

    private String lastOP = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerToButtons();
        addListenerToEditText();
    }

    public void addListenerToButtons() {
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_multi = (Button) findViewById(R.id.btn_multi);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_sign = (Button) findViewById(R.id.btn_sign);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_eq = (Button) findViewById(R.id.btn_eq);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearOnInput) {
                    display.setText("");
                    clearOnInput = false;
                }
                display.append("0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearOnInput) {
                    display.setText("");
                    clearOnInput = false;
                }
                display.append("1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearOnInput) {
                    display.setText("");
                    clearOnInput = false;
                }
                display.append("2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearOnInput) {
                    display.setText("");
                    clearOnInput = false;
                }
                display.append("3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearOnInput) {
                    display.setText("");
                    clearOnInput = false;
                }
                display.append("4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearOnInput) {
                    display.setText("");
                    clearOnInput = false;
                }
                display.append("5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearOnInput) {
                    display.setText("");
                    clearOnInput = false;
                }
                display.append("6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearOnInput) {
                    display.setText("");
                    clearOnInput = false;
                }
                display.append("7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearOnInput) {
                    display.setText("");
                    clearOnInput = false;
                }
                display.append("8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearOnInput) {
                    display.setText("");
                    clearOnInput = false;
                }
                display.append("9");
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0) {
                    display.setText(display.getText().toString().substring(0, display.getText().length() - 1));
                }
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
                sum = 0;
                firstInput = true;
            }
        });
        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0) {
                    char firstCh = display.getText().toString().charAt(0);
                    if (firstCh == '-') {
                        display.setText(display.getText().toString().substring(1));
                    } else {
                        display.setText("-" + display.getText().toString());
                    }
                }
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0) {
                    if(!display.getText().toString().equals("0")) {
                        if(sum == 0)
                            sum = 1;
                        if(firstInput == true) {
                            sum = Double.parseDouble(display.getText().toString());
                            firstInput = false;
                        }else
                            sum = sum / Double.parseDouble(display.getText().toString());
                        display.setText(String.valueOf(sum));
                        clearOnInput = true;
                        lastOP = "/";
                    }
                }
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0) {
                    if(firstInput == true) {
                        sum = Double.parseDouble(display.getText().toString());
                        firstInput = false;
                    }else
                        sum = sum + Double.parseDouble(display.getText().toString());
                    display.setText(String.valueOf(sum));
                    clearOnInput = true;
                    lastOP = "+";
                }
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0) {
                    if(firstInput == true) {
                        sum = Double.parseDouble(display.getText().toString());
                        firstInput = false;
                    }else
                        sum = sum - Double.parseDouble(display.getText().toString());
                    display.setText(String.valueOf(sum));
                    clearOnInput = true;
                    lastOP = "-";
                }
            }
        });
        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0) {
                    if(sum == 0)
                        sum = 1;
                    if(firstInput == true) {
                        sum = Double.parseDouble(display.getText().toString());
                        firstInput = false;
                    }else
                        sum = sum * Double.parseDouble(display.getText().toString());
                    display.setText(String.valueOf(sum));
                    clearOnInput = true;
                    lastOP = "*";
                }
            }
        });
        btn_eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0){
                    switch(lastOP) {
                        case "+":
                            sum = sum + Double.parseDouble(display.getText().toString());
                            display.setText(String.valueOf(sum));
                            break;
                        case "-":
                            sum = sum - Double.parseDouble(display.getText().toString());
                            display.setText(String.valueOf(sum));
                            break;
                        case "*":
                            sum = sum * Double.parseDouble(display.getText().toString());
                            display.setText(String.valueOf(sum));
                            break;
                        case "/":
                            if (!display.getText().toString().equals("0")) {
                                sum = sum / Double.parseDouble(display.getText().toString());
                                display.setText(String.valueOf(sum));
                            }else
                                display.setText("ERR! DIV by 0");
                            break;
                        default:
                            break;
                    }
                }
                clearOnInput = true;
                sum = 0;
                firstInput = true;
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!display.getText().toString().contains(".")) {
                    display.append(".");
                }
            }
        });
    }

    public void addListenerToEditText(){
        display = (TextView) findViewById(R.id.display);
    }
}
