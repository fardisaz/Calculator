package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    TextArea frame;

    String operator="";
    String first_Operand="";
    String prevOperator="";

    public void initialize(){
        frame.setText("0");

    }

    public void handleDigits(ActionEvent e){
        Button b=(Button)e.getSource();
        String c=b.getText();//the button we pushed
        String prev=frame.getText();//the text on text area

        if(prev.equals("0")){
            frame.clear();
            frame.setText(c);
        }
        else if(!operator.equals("")){
            first_Operand=prev;
            //frame.clear();
            frame.setText(c);
            prevOperator=operator;
            operator="";
        }
        else{
            c=prev.concat(c);
            frame.setText(c);
        }


    }

    public void handleOperator(ActionEvent e){
        Button b=(Button) e.getSource();
        String c=b.getText();

        if (!c.equals("=")){
            operator=c;
        }else if(c.equals("=")){
            System.out.println(first_Operand+prevOperator+frame.getText());
            int a=Integer.parseInt(first_Operand);
            int d=Integer.parseInt(frame.getText());
            switch (prevOperator){
                case "+":
                    frame.setText(String.valueOf(a+d));
                    break;
                case "-":
                    frame.setText(String.valueOf(a-d));
                    break;
                case "÷":
                    frame.setText(String.valueOf(a/d));
                    break;
                case "x":
                    frame.setText(String.valueOf(a*d));
                    break;
//                case "\\%":
//                    frame.setText(String.valueOf(a+d));
//                    break;

            }
        }

    }

}
