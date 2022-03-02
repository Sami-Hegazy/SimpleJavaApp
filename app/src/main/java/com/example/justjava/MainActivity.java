package com.example.justjava;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int numOfCoffees = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //__________________________________________________________________________________________
        Button btn_less = findViewById(R.id.btn_less);
        btn_less.setOnClickListener(this);
        Button btn_more = findViewById(R.id.btn_more);
        btn_more.setOnClickListener(this);
        Button btn_calc = findViewById(R.id.btn_calc);
        btn_calc.setOnClickListener(this);
        //__________________________________________________________________________________________
    }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));
    }


    private void displayMessage(String msg){
        TextView priceTxt = findViewById(R.id.orderSummary_txt_view);
        priceTxt.setText(msg);
    }




    private String createOrderSummary(){
        String summary = "Name : Sami" + "\nQuantity : " + numOfCoffees;
        summary += "\nTotal price : $ " + numOfCoffees * 5;
        summary +="\nThanks";
        return summary;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_less){
            if (numOfCoffees > 0){
                numOfCoffees--;
                display(numOfCoffees);
            }
        }else if (view.getId() == R.id.btn_more){
            numOfCoffees++;
            display(numOfCoffees);
        }else {
            String message = createOrderSummary();
            displayMessage(message);
        }
    }
}