package com.shahira.myuacademy.screens.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.math.RoundingMode
import kotlin.math.ln
import kotlin.math.pow

@Composable
fun CalculatorCard(){
    // toggle state: false = Operations, true = Loans
    var isLoanMode by remember { mutableStateOf(false) }

    // mode selection
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { isLoanMode = false },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (!isLoanMode) Color(0xFFA5D6A7) else Color.LightGray,
                contentColor   = Color.White
            )
        ) {
            Text("Operations Calculator", color = Color.Black)
        }
        Button(
            onClick = { isLoanMode = true },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isLoanMode) Color(0xFFA5D6A7) else Color.LightGray,
                contentColor   = Color.White
            )
        ) {
            Text("Loan Calculator", color = Color.Black)
        }
    }

    if (!isLoanMode) {
        operations()
    } else {
        loans()
    }
}

@Composable
private fun operations() {

    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<Double?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // parse to Double, default to 0.0 if blank or invalid
    val num1 = input1.toDoubleOrNull() ?: 0.0
    val num2 = input2.toDoubleOrNull() ?: 0.0
    Column() {
        Row(
            modifier = Modifier
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextField(
                value = input1,
                onValueChange = { input1 = it },
                label = { Text("First number") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            TextField(
                value = input2,
                onValueChange = { input2 = it },
                label = { Text("Second number") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            )
            {
                Button(
                    onClick = {
                        result = num1 + num2
                        errorMessage = null
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF125E12),
                        contentColor = Color.White
                    )
                ) {
                    Text("Add")
                }
                Button(
                    onClick = {
                        result = num1 - num2
                        errorMessage = null
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF125E12),
                        contentColor = Color.White
                    )
                ) {
                    Text("Subtract")
                }
            }
            Row(
                modifier = Modifier
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            )
            {
                Button(
                    onClick = {
                        result = num1 * num2
                        errorMessage = null
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF125E12),
                        contentColor = Color.White
                    )
                ) {
                    Text("Multiply")
                }
                Button(
                    onClick = {
                        if (num2 == 0.0) {
                            errorMessage = "DIVISOR CANNOT BE ZERO"
                            result = null
                        } else {
                            result = num1 / num2
                            errorMessage = null
                        }
                    }, // handle divide by zero error
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF125E12),
                        contentColor = Color.White
                    )
                ) {
                    Text("Divide")
                }
            }
            if (errorMessage == null) {
                // No error → show result (if present)
                result?.let { value ->
                    Text(
                        text = "Result: $value",
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )
                }
            } else {
                // There is an error → show it in red
                Text(
                    text = errorMessage!!,
                    fontSize = 30.sp,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
        }
    }
}
    @Composable
    private fun loans(){
        var year by remember { mutableStateOf("") }
        var rate by remember { mutableStateOf("") }
        var loan by remember { mutableStateOf("") }
        var payment by remember { mutableStateOf("") }
        var result by remember { mutableStateOf<Double?>(null) }
        var errorMessage by remember { mutableStateOf<String?>(null) }

        Column(modifier = Modifier
            .padding(16.dp),verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = year,
                    onValueChange = { year = it },
                    label = { Text("Years") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
                TextField(
                    value = rate,
                    onValueChange = { rate = it },
                    label = { Text("Interest Rate") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
            }
            Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = loan,
                    onValueChange = { loan = it },
                    label = { Text("Loan Amount") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
                TextField(
                    value = payment,
                    onValueChange = { payment = it },
                    label = { Text("Monthly Payment") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )

            }
            Button(onClick = {
                val y  = year.toDoubleOrNull()
                val r   = rate.toDoubleOrNull()
                val p   = loan.toDoubleOrNull()
                val pmt  = payment.toDoubleOrNull()

                if (listOf(y, r, p, pmt).count { it == null } != 1) {
                    errorMessage = "Exactly 3 of 4 Fields Must Be Filled"
                    result = null
                } else {
                    result = solveLoan(y, r, p, pmt)
                    errorMessage  = null
                }
            }, modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF125E12),
                    contentColor = Color.White
                )) {
                Text("Calculate")
            }

            errorMessage?.let { msg ->
                Text(
                    text = msg,
                    fontSize = 30.sp,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
            result?.let { raw ->
                val rounded = raw
                    .toBigDecimal()
                    .setScale(3, RoundingMode.HALF_UP) // rounds answer to three decimal places
                    .toDouble()
                Text(
                    text = "Result: $rounded",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
        }
    }
/**
 * Solves for the one missing variable in the standard loan formula:
 *     PMT = P * i / (1 - (1+i)^(-n))
 * where i = r/12, n = 12*y.
 * Rearranges for whichever of y, r, p, pmt is null.
 */

fun solveLoan(y: Double?, r: Double?, p: Double?, pmt: Double?): Double {
    fun monthlyRate(annual: Double) = annual / 12
    fun periods(years: Double) = years * 12

    return when {
        // solve for years (y)
        y == null -> {
            val i = monthlyRate(r!!)
            val ratio = 1 - p!! * i / pmt!!
            val n = -ln(ratio) / ln(1 + i)
            n / 12
        }
        // solve for interest rate (r)
        r == null -> {
            val target = pmt!!
            val n = periods(y!!)
            var lo = 0.0
            var hi = 1.0
            repeat(50) {
                val mid = (lo + hi) / 2
                val f = p!! * mid / (1 - (1 + mid).pow(-n)) - target
                if (f > 0) hi = mid else lo = mid
            }
            (lo + hi) / 2 * 12
        }
        // solve for loan amount (p)
        p == null -> {
            val i = monthlyRate(r!!)
            val n = periods(y!!)
            pmt!! * (1 - (1 + i).pow(-n)) / i
        }
        // solve for monthly payment (pmt)
        pmt == null -> {
            val i = monthlyRate(r!!)
            val n = periods(y!!)
            p!! * i / (1 - (1 + i).pow(-n))
        }
        else -> throw IllegalArgumentException("Exactly 3 of 4 arguments must be null")
    }
    }

