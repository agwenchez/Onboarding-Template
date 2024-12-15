package com.example.onboardingtemplate.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboardingtemplate.R


@Composable
fun SignUpScreen(onLoginClick: () -> Unit){
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    Surface(
//            modifier = Modifier.border(2.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
    ){
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color.White)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.35f)
                    .background(color = Color(android.graphics.Color.parseColor("#A0E67E"))),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Create an Account!",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(bottom = 40.dp),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.size(40.dp))

            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(
//                        start = 18.dp,  // Left padding
                        top = 220.dp,     // Top padding
//                        end = 18.dp,    // Right padding
//                        bottom = 24.dp  // Bottom padding
                    )
//                    .align(Alignment.Center)
                    .clip(
                        RoundedCornerShape(
                            topStart = 32.dp, // Top-left corner radius
                            topEnd = 32.dp    // Top-right corner radius
                        )
                    )
                    .background(color = Color.White)
                    .padding(horizontal = 24.dp),
//                    .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Spacer(modifier = Modifier.size(45.dp))
                ToggleButtons()

                Spacer(modifier = Modifier.size(40.dp))

                EditNumberField(
                    label = R.string.email_label,
//                    leadingIcon = R.drawable.percent,
                    value = emailInput,
                    onValueChange = { emailInput = it},
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .fillMaxWidth(),
                    placeholder = { Text("Enter your email") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    )
                )
                EditNumberField(
                    label = R.string.password_label,
//                    leadingIcon = R.drawable.percent,
                    value = passwordInput,
                    onValueChange = { passwordInput = it},
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .fillMaxWidth(),
                    placeholder = { Text( text = "Enter your password") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    )
                )
                Spacer(modifier = Modifier.size(30.dp))

                Button(
                    onClick = onLoginClick,
                    modifier = Modifier
//                        .padding(bottom = 240.dp)
                        .height(40.dp)
                        .fillMaxWidth(),
//                        .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color(android.graphics.Color.parseColor("#388E3C"))
                    )
//                        .background(color = Color(android.graphics.Color.parseColor("#FF6F00")))
                ){
                    Text(
                        text = "Register",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.size(240.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview(){
    SignUpScreen() {  }
}


