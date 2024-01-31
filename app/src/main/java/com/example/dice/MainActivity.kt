package com.example.dice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dice.ui.theme.DiceTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp("Android")
                }
            }
        }
    }
}

@Composable
fun DiceRollerApp(name: String, modifier: Modifier = Modifier) {
    // Mutable state for holding the dice roll value
    var diceRoll by remember { mutableStateOf(0) }

    // Function to roll the dice
    fun rollDice() {
        diceRoll = Random.nextInt(1, 7)  // Random number between 1 and 6
    }

    Column(modifier = modifier) {
        Text(text = "Hello $name!", modifier = modifier)
        Button(onClick = { rollDice() }) {
            Text(text = "Roll Dice")
        }
        if (diceRoll > 0) {
            Text(text = "Dice Rolled: $diceRoll", modifier = modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerPreview() {
    DiceTheme {
        DiceRollerApp("Android")
    }
}
