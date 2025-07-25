package com.shahira.myuacademy.screens.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
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
import kotlin.math.ln
import kotlin.math.pow

@Composable
fun CalculatorCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        // ─── Operations ────────────────────────────────────────────
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            var input1 by remember { mutableStateOf("") }
            var input2 by remember { mutableStateOf("") }
            var result by remember { mutableStateOf<Double?>(null) }
            var errorMsg by remember { mutableStateOf<String?>(null) }
            val num1 = input1.toDoubleOrNull() ?: 0.0
            val num2 = input2.toDoubleOrNull() ?: 0.0

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = input1,
                    onValueChange = { input1 = it },
                    label = { Text("First") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 56.dp)
                )
                TextField(
                    value = input2,
                    onValueChange = { input2 = it },
                    label = { Text("Second") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 56.dp)
                )
            }
            Spacer(modifier = Modifier.height(7.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf(
                    "Add" to { result = num1 + num2; errorMsg = null },
                    "Subtract" to { result = num1 - num2; errorMsg = null },
                    "Multiply" to { result = num1 * num2; errorMsg = null },
                    "Divide" to {
                        if (num2 == 0.0) { errorMsg = "÷ by zero"; result = null }
                        else { result = num1 / num2; errorMsg = null }
                    }
                ).forEach { (label, action) ->
                    Button(
                        onClick = action,
                        modifier = Modifier
                            .weight(1f)
                            .height(32.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF125E12),
                            contentColor = Color.White
                        )
                    ) {
                        Text(label, fontSize = 11.sp)
                    }
                }
            }

            Text(
                text = errorMsg ?: result?.let { "Result: $it" }.orEmpty(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = if (errorMsg != null) Color.Red else Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        }

        Spacer(modifier = Modifier.height(0.3.dp))

        // ─── Loan Calculator ────────────────────────────────────────
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            var year by remember { mutableStateOf("") }
            var rate by remember { mutableStateOf("") }
            var loan by remember { mutableStateOf("") }
            var payment by remember { mutableStateOf("") }
            var error2 by remember { mutableStateOf<String?>(null) }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = year,
                    onValueChange = { year = it },
                    label = { Text("Years") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 56.dp)
                )
                TextField(
                    value = rate,
                    onValueChange = { rate = it },
                    label = { Text("Rate") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 56.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = loan,
                    onValueChange = { loan = it },
                    label = { Text("Loan") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 56.dp)
                )
                TextField(
                    value = payment,
                    onValueChange = { payment = it },
                    label = { Text("Pay") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 56.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    val y = year.toDoubleOrNull()
                    val raw = rate.trim()
                    val pRate = raw.removeSuffix("%").toDoubleOrNull()?.let {
                        if (raw.endsWith("%") || it > 1.0) it / 100 else it
                    }
                    val p = loan.toDoubleOrNull()
                    val pmt = payment.toDoubleOrNull()
                    if (listOf(y, pRate, p, pmt).count { it == null } != 1) {
                        error2 = "Fill exactly 3 of 4"
                    } else {
                        error2 = null
                        val out = solveLoan(y, pRate, p, pmt)
                        when {
                            y == null    -> year = "%.2f".format(out)
                            pRate == null-> rate = "%.2f%%".format(out * 100)
                            p == null    -> loan = "%.2f".format(out)
                            pmt == null  -> payment = "%.2f".format(out)
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF125E12),
                    contentColor = Color.White
                )
            ) {
                Text("Calc", fontSize = 12.sp)
            }
            error2?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // ─── Temperature Converter ──────────────────────────────────
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            var f by remember { mutableStateOf("") }
            var c by remember { mutableStateOf("") }
            var error3 by remember { mutableStateOf<String?>(null) }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = f,
                    onValueChange = { f = it },
                    label = { Text("F°") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 56.dp)
                )
                TextField(
                    value = c,
                    onValueChange = { c = it },
                    label = { Text("C°") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 56.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    val fv = f.toDoubleOrNull()
                    val cv = c.toDoubleOrNull()
                    if (listOf(fv, cv).count { it == null } != 1) {
                        error3 = "Fill exactly 1 field"
                    } else {
                        error3 = null
                        val out = convertTemp(fv, cv)
                        if (fv == null) f = "%.2f".format(out) else c = "%.2f".format(out)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF125E12),
                    contentColor = Color.White
                )
            ) {
                Text("Calc", fontSize = 12.sp)
            }
            error3?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // ─── Weight Converter ────────────────────────────────────────
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            var lb by remember { mutableStateOf("") }
            var kg by remember { mutableStateOf("") }
            var error4 by remember { mutableStateOf<String?>(null) }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = lb,
                    onValueChange = { lb = it },
                    label = { Text("lb") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 56.dp)
                )
                TextField(
                    value = kg,
                    onValueChange = { kg = it },
                    label = { Text("kg") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 56.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    val l = lb.toDoubleOrNull()
                    val k = kg.toDoubleOrNull()
                    if (listOf(l, k).count { it == null } != 1) {
                        error4 = "Fill exactly 1 field"
                    } else {
                        error4 = null
                        val out = convertWeight(l, k)
                        if (l == null) lb = "%.2f".format(out) else kg = "%.2f".format(out)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF125E12),
                    contentColor = Color.White
                )
            ) {
                Text("Calc", fontSize = 12.sp)
            }
            error4?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
        }
    }
}

// ─── Helper functions ─────────────────────────────────────────

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

/**
 * Solves for the one missing variable in the standard temperature conversion formula:
 *     F = 9/5 * C + 32
 * Rearranges for whichever of f or c is null.
 */

fun convertTemp(f: Double?, c: Double?): Double{
    return when{
        f == null -> {
            (9.0/5.0 * c!!) + 32.0
        }
        c == null -> {
            (f!! - 32.0) * 5.0/9
        }
        else -> throw IllegalArgumentException("Exactly 1 argument must be null")
    }
}

/**
 * Solves for the one missing variable in the standard weight conversion formula:
 *     kg = lb * 0.45359237
 *     Rearranges for whichever of lb or kg is null.
 */

fun convertWeight(lb: Double?, kg: Double?): Double{
    return when{
        lb == null -> {
            kg!! * 2.20462262
        }
        kg == null -> {
            lb!! * 0.45359237
        }
        else -> throw IllegalArgumentException("Exactly 1 argument must be null")
    }
}
