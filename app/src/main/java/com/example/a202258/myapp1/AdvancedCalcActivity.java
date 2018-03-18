package com.example.a202258.myapp1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.cos;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.tan;

public class AdvancedCalcActivity extends AppCompatActivity {
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_c,
            btn_ac, btn_sign, btn_div, btn_multi, btn_sub, btn_add, btn_dot, btn_eq,
            btn_sin, btn_cos, btn_tan, btn_ln, btn_sqrt, btn_log, btn_pow2, btn_powy, btn_proc;
    private TextView display;
    private double sum = 0;
    private boolean firstInput = true;
    private boolean clearOnInput = false;
    private String lastOP = "";
    private int countCClicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advancedcalc);

        if(savedInstanceState != null){
            sum = savedInstanceState.getDouble("SUM_STATE_KEY");
            firstInput = savedInstanceState.getBoolean("FIRSTINPUT_STATE_KEY");
            clearOnInput = savedInstanceState.getBoolean("CLEARONINPUT_STATE_KEY");
            countCClicks = savedInstanceState.getInt("COUNTCCLICKS_STATE_KEY");
            lastOP = savedInstanceState.getString("LASTOP_STATE_KEY");

        }
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
        btn_ac = (Button) findViewById(R.id.btn_ac);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_multi = (Button) findViewById(R.id.btn_multi);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_sign = (Button) findViewById(R.id.btn_sign);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_eq = (Button) findViewById(R.id.btn_eq);
        btn_sin = (Button) findViewById(R.id.btn_sin);
        btn_cos = (Button) findViewById(R.id.btn_cos);
        btn_tan = (Button) findViewById(R.id.btn_tan);
        btn_ln = (Button) findViewById(R.id.btn_ln);
        btn_sqrt = (Button) findViewById(R.id.btn_sqrt);
        btn_pow2 = (Button) findViewById(R.id.btn_pow2);
        btn_powy = (Button) findViewById(R.id.btn_powy);
        btn_log = (Button) findViewById(R.id.btn_log);
        btn_proc = (Button) findViewById(R.id.btn_proc);

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
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countCClicks++;
                display.setText("");
                sum = 0;
                firstInput = true;
                countCClicks = 0;
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countCClicks++;
                display.setText("");

                if(countCClicks == 2){
                    sum = 0;
                    firstInput = true;
                    countCClicks = 0;
                }
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
                        String val = String.valueOf(sum);
                        if(!val.equals("Infinity") && !val.equals("NaN"))
                            display.setText(val);
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
                    String val = String.valueOf(sum);
                    if(!val.equals("Infinity") && !val.equals("NaN"))
                        display.setText(val);
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
                    String val = String.valueOf(sum);
                    if(!val.equals("Infinity") && !val.equals("NaN"))
                        display.setText(val);
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
                    String val = String.valueOf(sum);
                    if(!val.equals("Infinity") && !val.equals("NaN"))
                        display.setText(val);
                    clearOnInput = true;
                    lastOP = "*";
                }
            }
        });
        btn_sin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(display.getText().length() > 0){
                        sum = sin(Double.parseDouble(display.getText().toString()));
                        display.setText(String.valueOf(sum));
                        clearOnInput = true;
                    }
                };
        });
        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0){
                    sum = cos(Double.parseDouble(display.getText().toString()));
                    display.setText(String.valueOf(sum));
                    clearOnInput = true;
                }
            };
        });
        btn_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0){
                    sum = tan(Double.parseDouble(display.getText().toString()));
                    display.setText(String.valueOf(sum));
                    clearOnInput = true;
                }
            };
        });
        btn_ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0){
                    double val = Double.parseDouble(display.getText().toString());
                    if(val > 0) {
                        sum = log(val);
                        display.setText(String.valueOf(sum));
                        clearOnInput = true;
                    }else{
                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, "Invalid argument - use positive number", duration);
                        toast.show();
                    }
                }
            };
        });
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0){
                    double val = Double.parseDouble(display.getText().toString());
                    if(val > 0) {
                        sum = log(val) / log(10);
                        display.setText(String.valueOf(sum));
                        clearOnInput = true;
                    }else{
                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, "Invalid argument - use positive number", duration);
                        toast.show();
                    }
                }
            };
        });
        btn_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0){
                    sum = sqrt(Double.parseDouble(display.getText().toString()));
                    display.setText(String.valueOf(sum));
                    clearOnInput = true;
                }
            };
        });
        btn_pow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0){
                    sum = pow(Double.parseDouble(display.getText().toString()), 2);
                    display.setText(String.valueOf(sum));
                    clearOnInput = true;
                }
            };
        });
        btn_powy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0) {
                    if(firstInput == true) {
                        sum = Double.parseDouble(display.getText().toString());
                        firstInput = false;
                    }else
                        sum = pow(sum, Double.parseDouble(display.getText().toString()));
                    String val = String.valueOf(sum);
                    if(!val.equals("Infinity") && !val.equals("NaN"))
                        display.setText(val);
                    clearOnInput = true;
                    lastOP = "powy";
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
                            }else{
                                Context context = getApplicationContext();
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(context, "Invalid operation - Dividing by zero", duration);
                                toast.show();
                            }
                            break;
                        case "powy":
                            sum = pow(sum, Double.parseDouble(display.getText().toString()));
                            display.setText(String.valueOf(sum));

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
        btn_proc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.getText().length() > 0){
                    switch(lastOP) {
                        case "/":
                            sum = sum / Double.parseDouble(display.getText().toString()) * 100;
                            display.setText(String.valueOf(sum));
                            break;
                        case "*":
                            sum = sum * Double.parseDouble(display.getText().toString())/100;
                            display.setText(String.valueOf(sum));
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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putDouble("SUM_STATE_KEY", sum);
        outState.putBoolean("FIRSTINPUT_STATE_KEY", firstInput);
        outState.putBoolean("CLEARONINPUT_STATE_KEY", clearOnInput);
        outState.putInt("COUNTCCLICKS_STATE_KEY", countCClicks);
        outState.putString("LASTOP_STATE_KEY", lastOP);

        super.onSaveInstanceState(outState);
    }
}
