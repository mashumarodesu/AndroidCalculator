package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView calculationTV;
    TextView resultTV;

    String calculationS = "";

    boolean isIdle = true;
    boolean leftParenthesis = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTextViews();
    }

    private void initTextViews() {
        calculationTV = (TextView)findViewById(R.id.calculation);
        resultTV = (TextView)findViewById(R.id.result);
    }

    private void setCalculationS (String input) {
        calculationS += input;
        calculationTV.setText(calculationS);
    }



    public void clear(View view) {
        calculationS = "";
        calculationTV.setText("");
        resultTV.setText("0");
        isIdle = true;
    }

    public void delete(View view) {
        if (calculationS.length() > 0) {
            StringBuffer tempSB = new StringBuffer(calculationS);

            if (tempSB.charAt(tempSB.length() - 1) == '(') {
                leftParenthesis = true;
            }

            if (tempSB.charAt(tempSB.length() - 1) == ')') {
                leftParenthesis = false;
            }

            tempSB.deleteCharAt(tempSB.length() - 1);
            calculationS = tempSB.toString();
            calculationTV.setText(calculationS);
        }
    }

    public void type0(View view) {
        if (isIdle) {
            calculationS = "";
            calculationTV.setText("");
            resultTV.setText("0");
            isIdle = false;
        }
        setCalculationS("0");
    }

    public void type1(View view) {
        if (isIdle) {
            calculationS = "";
            calculationTV.setText("");
            resultTV.setText("0");
            isIdle = false;
        }
        setCalculationS("1");
    }

    public void type2(View view) {
        if (isIdle) {
            calculationS = "";
            calculationTV.setText("");
            resultTV.setText("0");
            isIdle = false;
        }
        setCalculationS("2");
    }

    public void type3(View view) {
        if (isIdle) {
            calculationS = "";
            calculationTV.setText("");
            resultTV.setText("0");
            isIdle = false;
        }
        setCalculationS("3");
    }

    public void type4(View view) {
        if (isIdle) {
            calculationS = "";
            calculationTV.setText("");
            resultTV.setText("0");
            isIdle = false;
        }
        setCalculationS("4");
    }

    public void type5(View view) {
        if (isIdle) {
            calculationS = "";
            calculationTV.setText("");
            resultTV.setText("0");
            isIdle = false;
        }
        setCalculationS("5");
    }

    public void type6(View view) {
        if (isIdle) {
            calculationS = "";
            calculationTV.setText("");
            resultTV.setText("0");
            isIdle = false;
        }
        setCalculationS("6");
    }

    public void type7(View view) {
        if (isIdle) {
            calculationS = "";
            calculationTV.setText("");
            resultTV.setText("0");
            isIdle = false;
        }
        setCalculationS("7");
    }

    public void type8(View view) {
        if (isIdle) {
            calculationS = "";
            calculationTV.setText("");
            resultTV.setText("0");
            isIdle = false;
        }
        setCalculationS("8");
    }

    public void type9(View view) {
        if (isIdle) {
            calculationS = "";
            calculationTV.setText("");
            resultTV.setText("0");
            isIdle = false;
        }
        setCalculationS("9");
    }

    public void Parenthesis(View view) {
        if (isIdle) {
            calculationS = "";
            calculationTV.setText("");
            resultTV.setText("0");
            isIdle = false;
        }

        if (leftParenthesis) {
            setCalculationS("(");
            leftParenthesis = false;
        } else {
            setCalculationS(")");
            leftParenthesis = true;
        }
    }

    public void dot(View view) {
        if (isIdle) {
            calculationS = "";
            calculationTV.setText("");
            resultTV.setText("0");
            isIdle = false;
        }
        setCalculationS(".");
    }

    public void add(View view) {
        setCalculationS("+");
        isIdle = false;
    }

    public void subtract(View view) {
        setCalculationS("-");
        isIdle = false;
    }

    public void multiply(View view) {
        setCalculationS("*");
        isIdle = false;
    }

    public void divide(View view) {
        setCalculationS("/");
        isIdle = false;
    }

    public void calculate(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double)engine.eval(calculationS);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Equation", Toast.LENGTH_SHORT).show();
        }

        if (result != null) {
            if (Math.round(result) == result) {
                resultTV.setText(String.format("%.0f", result.doubleValue()));
            } else {
                resultTV.setText(String.valueOf(result.doubleValue()));
            }
        }

        isIdle = true;
    }
}