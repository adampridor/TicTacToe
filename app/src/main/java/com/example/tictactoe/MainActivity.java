package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    String turn;
    String [] [] board;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onNewGame();
    }
    private void onNewGame() {
        board = new String[3][3];
        for (int row=0; row < 3; row++)
            for (int col=0; col < 3; col++)
                board[row][col] = new String();

        turn = "X";
        count = 0;
    }

    private void handleClick ( int row, int col, int id){
        if (board[row][col].equals("")) {
            board[row][col] = turn;
            Button btn = findViewById(id);
            btn.setText(turn);
            onTurnEnd();
        }
    }

    public void onButtonClick(View view) {
        int id = view.getId();

        if(id==R.id.btn_00)
        {
            handleClick(0, 0, R.id.btn_00);
        }
        else if(id==R.id.btn_01)
        {
            handleClick(0, 1, R.id.btn_01);
        }
        else if(id==R.id.btn_02)
        {
            handleClick(0, 2, R.id.btn_02);
        }
        else if(id==R.id.btn_10)
        {
            handleClick(1, 0, R.id.btn_10);
        }
        else if(id==R.id.btn_11)
        {
            handleClick(1, 1, R.id.btn_11);
        }
        else if(id==R.id.btn_12)
        {
            handleClick(1, 2, R.id.btn_12);
        }
        else if(id==R.id.btn_20)
        {
            handleClick(2, 0, R.id.btn_20);
        }
        else if(id==R.id.btn_21)
        {
            handleClick(2, 1, R.id.btn_21);
        }
        else if(id==R.id.btn_22)
        {
            handleClick(2, 2, R.id.btn_22);
        }
    }


        private void onTurnEnd () {
            if (isWinner())
                endGame(turn + " won!");
            else {
                count++;
                if (count == 9)
                    endGame("Tie");
                else {
                    turn = (turn.equals("X") ? "O" : "X");
                }
            }
        }

        private void endGame (String s)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("We have a winner!");
            String msg = "The winner is:" + s;
            builder.setMessage(msg);
            if(s.equals("Tie"))
            {
                builder.setTitle("We got a tie");
                msg = "The result is : " + s;
            }

            builder.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {

                }
            });
            AlertDialog dialog = builder.show();

        }

        private boolean isWinner ()
        {
            for(int i=0; i<3; i++)
            {
                if(board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals(""))
                {
                    return true;
                }
            }
            for (int i=0; i<3; i++)
            {
                if(board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals(""))
                {
                    return true;
                }
            }
            if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals(""))
            {
                return true;
            }
            if(board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[1][1].equals(""))
            {
                return true;
            }
            return false;
        }


}