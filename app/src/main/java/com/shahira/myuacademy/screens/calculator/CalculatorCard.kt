package com.shahira.myuacademy.screens.calculator

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.Math.pow
import kotlin.math.*
//import kotlin.math.ln
//import kotlin.math.pow


class Item(
    price: String = "",
    qty: String = ""
) {
    var price by mutableStateOf(price)
    var qty by mutableStateOf(qty)
} // class for multi-item totalizer

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun CalculatorCard() {

    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var sum by remember { mutableStateOf(0) }
    var result by remember { mutableStateOf(0.0) }

    var year by remember { mutableStateOf("") }
    var rate by remember { mutableStateOf("") }
    var loan by remember { mutableStateOf("") }
    var payment by remember { mutableStateOf("") }
    var error2 by remember { mutableStateOf<String?>(null) }
    var error1 by remember { mutableStateOf("") }



    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .background(Color.White)) {
        Column(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(
                    start = 5.dp, end = 5.dp, bottom = 10.dp
                )
        ) {
            Text(
                text = "Math Calculator",
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TextField(
                    value = number1,
                    onValueChange = { number1 = it },
                    modifier = Modifier.width(150.dp),
                    label = {
                        Text(
                            "a",
                            fontWeight = FontWeight.Bold
                        )
                    }
                )

                TextField(
                    value = number2,
                    onValueChange = { number2 = it },
                    modifier = Modifier.width(150.dp),
                    label = { Text("b", fontWeight = FontWeight.Bold) }
                    // color = Color(0xFF125E12)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth().height(35.dp),
                horizontalArrangement = Arrangement.Absolute.Left,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = "Result =",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 5.dp)
                )

                Text(
                    // text = sum.toString(),
                    text = result.toString(),
                    fontSize = 20.sp,
                    color = Color.White
                )

                Text(
                    // text = sum.toString(),
                    text = error1.toString(),
                    fontSize = 20.sp,
                    color = Color.Red
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextButton(
                    onClick = {
                        if (number1=="" || number2=="") {
                            result=0.0
                            error1 = " Enter numbers to a & b"
                        } else {
                            error1 = ""
                            result = number1.toDouble() + number2.toDouble()
                        }
                       },
                    colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier.height(33.dp)
                ) {
                    Text(
                        "a+b",
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = {

                        if (number1=="" || number2=="") {
                            result=0.0
                            error1 = " Enter numbers to a & b"
                        } else {
                            error1 = ""
                        result = number1.toDouble() - number2.toDouble() }},
                    colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier.height(33.dp)
                ) {
                    Text(
                        "a-b",
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = {

                        if (number1=="" || number2=="") {
                            result=0.0
                            error1 = " Enter numbers to a & b"
                        } else {
                            error1 = ""
                        result = number1.toDouble() * number2.toDouble() }},
                    colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier.height(33.dp)
                ) {
                    Text(
                        "axb",
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = {

                        if (number1=="" || number2=="") {
                            result=0.0
                            error1 =" Enter numbers to a & b"
                        } else {
                            error1 = ""
                        result = number1.toDouble() / number2.toDouble() }},
                    colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier.height(33.dp)
                ) {
                    Text(
                        "a/b",
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = {

                        if (number1=="" || number2=="") {
                            result=0.0
                            error1 = " Enter numbers to a & b"
                        } else {
                            error1 = ""
                        result = pow(number1.toDouble(), number2.toDouble()) }},
                    colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier.height(33.dp)
                ) {
                    Text(
                        "a^b",
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = {
                        if (number1=="" || number2=="") {
                            result=0.0
                            error1 = " Enter numbers to a & b"
                        } else {
                            error1 = ""
                        result = pow(number2.toDouble(), 1 / number1.toDouble()) }},
                    colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier.height(33.dp)
                ) {
                    Text(
                        "a" + "\u221A" + "b",
                        color = Color.White
                    )
                }

            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(

                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            )
            {

                TextButton(
                    onClick = {
                        error1=""
                        result = PI },
                    colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier.height(33.dp)
                ) {
                    Text(
                        "pi",
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = {
                        if (number1=="" ) {
                            result=0.0
                            error1 = " Enter a  number to a"
                        } else {
                            error1 = ""
                        result = Math.sin(number1.toDouble()) }},
                    colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier.height(33.dp)
                ) {
                    Text(
                        "sin(a)",
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = {
                        if (number1=="") {
                            result=0.0
                            error1 = " Enter a number to a"
                        } else {
                            error1 = ""
                        result = Math.cos(number1.toDouble()) }},
                    colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier.height(33.dp)
                ) {
                    Text(
                        "cos(a)",
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = {
                        if (number1=="") {
                            result=0.0
                            error1 = " Enter a number to a"
                        } else {
                            error1 = ""
                        result = Math.tan(number1.toDouble()) }},
                    colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier.height(33.dp)
                ) {
                    Text(
                        "tan(a)",
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = {
                        if (number1=="" || number1.toDouble()<0) {
                            error1 = " Enter a positive number to a"
                            result=0.0
                        } else {
                            error1 = ""
                        result =ln(number1.toDouble()) }},
                    colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier.height(33.dp)
                ) {
                    Text(
                        "ln(a)",
                        color = Color.White
                    )
                }

                TextButton(
                    onClick = {
                        if (number1=="" || number1.toDouble()<0) {
                            error1 = " Enter a positive numbers to a"
                            result=0.0
                        } else {
                            error1 = ""
                        result = log10(number1.toDouble()) }},
                    colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier.height(33.dp)
                ) {
                    Text(
                        "log(a)",
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }


    // ─── Loan Calculator ────

    Spacer(modifier = Modifier.height(25.dp))
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .background(Color.White)) {

        Column(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
        ) {

            Text(
                text = "Loan Calculator",
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly,

                ) {
                TextField(
                    value = year,
                    onValueChange = { year = it },
                    label = { Text("Loan Years:") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                    modifier = Modifier
                        .width(150.dp)
                        .height(47.dp)
                )
                TextField(
                    value = rate,
                    onValueChange = { rate = it },
                    label = { Text("Interest Rate:") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .width(150.dp)
                        .height(47.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TextField(
                    value = loan,
                    onValueChange = { loan = it },
                    label = { Text("Loan Amount:") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .width(150.dp)
                       // .height(47.dp)
                )
                TextField(
                    value = payment,
                    onValueChange = { payment = it },
                    label = { Text("Monthly Pay:") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .width(150.dp)
                       // .height(47.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
//                Text(
//                    text = "Fill in any three numbers then click Go",
//                    color = Color.White,
//                    fontSize = 15.sp,
//                    modifier = Modifier.padding(top = 5.dp)
//                )
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
                            error2 = "Fill in exactly 3 of 4 then click Go"
                        } else {
                            error2 = null
                            val out = solveLoan(y, pRate, p, pmt)
                            when {
                                y == null -> year = "%.2f".format(out)
                                pRate == null -> rate = "%.2f%%".format(out * 100)
                                p == null -> loan = "%.2f".format(out)
                                pmt == null -> payment = "%.2f".format(out)
                            }
                        }
                    },
                    modifier = Modifier
                        .width(70.dp)
                        .padding(bottom = 5.dp)
                        // .fillMaxWidth()
                        .height(32.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "Go",
                        fontSize = 15.sp,
                        color = Color.White
                    )
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
        }
    }
    Spacer(modifier = Modifier.height(25.dp))

    // ─── Multi–Item Totalizer  ────────────────────────────────────

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .background(Color.White)) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .height(40.dp)) {
            Text(
                text = "Shopping List Manager",
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }

        LazyColumn(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
//                .padding(
//                    start = 5.dp, end = 5.dp, bottom = 5.dp
               // )
        ) {

            item {
                val items = remember { mutableStateListOf(Item()) }
                var total by remember { mutableStateOf<Double?>(null) }
                var totalizerError by remember { mutableStateOf<String?>(null) }

                Column(Modifier
                    .fillMaxWidth()
                    .padding(5.dp)) {
                    // — Rows of price × qty
                    items.forEachIndexed { idx, item ->
                        Row(
                            Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            TextField(
                                value = item.price,
                                onValueChange = {
                                    item.price = it
                                    totalizerError = null
                                },
                                label = { Text("Price ${idx + 1}") },
                                singleLine = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier.width(150.dp)

                            )

                            TextField(
                                value = item.qty,
                                onValueChange = {
                                    item.qty = it
                                    totalizerError = null
                                },
                                label = { Text("Qty ${idx + 1}") },
                                singleLine = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier.width(150.dp)
                            )


                        }

                    }
                    Spacer(Modifier.height(10.dp))

                    // — Total button styled like Operations
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        TextButton(
                            onClick = {
                                val prods = items.mapNotNull {
                                    val p = it.price.toDoubleOrNull()
                                    val q = it.qty.toDoubleOrNull()
                                    if (p == null || q == null) null else p * q
                                }
                                if (prods.size < items.size) {
                                    total = null
                                    totalizerError = "Enter valid numbers in every field"
                                } else {
                                    total = prods.sum()
                                    totalizerError = null
                                }
                            },
                            modifier = Modifier
                                .height(32.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.DarkGray,
                            )
                        ) {
                            Text("Sum Items", color = Color.White)
                        }

                        TextButton(
                            onClick = {
                                items.add(Item())
                                totalizerError = null
                            },
                            colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                            shape = ButtonDefaults.textShape,
                            modifier = Modifier.height(33.dp)
                        ) {
                            Text(
                                "Add Items",
                                color = Color.White
                            )
                        }

                        TextButton(
                            onClick = {
                                if (items.size > 1) items.removeLast()
                                totalizerError = null
                            },
                            colors = ButtonDefaults.textButtonColors(containerColor = Color.DarkGray),
                            shape = ButtonDefaults.textShape,
                            modifier = Modifier.height(33.dp)
                        ) {
                            Text(
                                "Dele Items",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(Modifier.height(10.dp))
                    Row(
                        Modifier.fillMaxWidth().height(30.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {

                        Text(
                            text = totalizerError ?: total?.let { " Result: $${"%.2f".format(it)}" }
                                .orEmpty(),
                            color = if (totalizerError != null) Color.Red else Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                           // modifier = Modifier.align(Alignment.Start)
                        )
                    }
                }
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

fun convertTemp(f: Double?, c: Double?): Double {
    return when {
        f == null -> {
            (9.0 / 5.0 * c!!) + 32.0
        }

        c == null -> {
            (f!! - 32.0) * 5.0 / 9
        }

        else -> throw IllegalArgumentException("Exactly 1 argument must be null")
    }
}

/**
 * Solves for the one missing variable in the standard weight conversion formula:
 *     kg = lb * 0.45359237
 *     Rearranges for whichever of lb or kg is null.
 */

fun convertWeight(lb: Double?, kg: Double?): Double {
    return when {
        lb == null -> {
            kg!! * 2.20462262
        }

        kg == null -> {
            lb!! * 0.45359237
        }

        else -> throw IllegalArgumentException("Exactly 1 argument must be null")
    }
}
