package com.example.onboardingtemplate.auth

import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboardingtemplate.R
import kotlinx.coroutines.launch


@Composable
fun SignInScreen(onLoginClick: () -> Unit){
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
                    .background(color = Color(android.graphics.Color.parseColor("#121223"))),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(R.drawable.splash_logo_transparent), contentDescription = "logo", modifier = Modifier.size(120.dp))
                Text(
                    text = "Welcome Back",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 60.dp),
                    color = Color.White
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

                Spacer(modifier = Modifier.size(10.dp))
                ToggleButtons()

                Spacer(modifier = Modifier.size(30.dp))

                EditNumberField(
                    label = R.string.email_label,
//                    leadingIcon = R.drawable.percent,
                    value = emailInput,
                    onValueChange = { emailInput = it},
                    modifier = Modifier
                        .padding(bottom = 20.dp)
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
                Spacer(modifier = Modifier.size(20.dp))

                Button(
                    onClick = onLoginClick,
                    modifier = Modifier
//                        .padding(bottom = 240.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .fillMaxWidth(),
//                        .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color(android.graphics.Color.parseColor("#009944"))
                    ),
                    shape = RoundedCornerShape(10.dp),
//                        .background(color = Color(android.graphics.Color.parseColor("#FF6F00")))
                ){
                    Text(
                        text = "Login",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(android.graphics.Color.parseColor("#FFFFFF"))
                    )
                }
                Spacer(modifier = Modifier.size(50.dp).fillMaxWidth())
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                ){
                    Text(
                        text=" Don't have an account?",
                        color = Color.Black
                    )
                        Text(
                            text=" Register",
                            color = Color(android.graphics.Color.parseColor("#009944")),
                                modifier = Modifier.clickable{
                                    // Handle click action
                                    println("Text clicked!")
                                }
                        )

                }

                Spacer(modifier = Modifier.size(240.dp))
            }
        }
    }
}


@Composable
fun ToggleButtons(){
    var selectedButton by remember { mutableStateOf("Customer") }

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Color(android.graphics.Color.parseColor("#E0E0E0")))
            .padding(horizontal = 4.dp, vertical = 0.dp) // Inner padding for spacing
    ) {
        Button(
            onClick = { selectedButton = "Customer" },
            modifier = Modifier
                .weight(1f) // Each button takes up equal space
                .padding(end = 4.dp), // Space between buttons
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(android.graphics.Color.parseColor("#FFFFFF")),
                containerColor = if (selectedButton == "Customer") Color(android.graphics.Color.parseColor("#00A36C")) else Color.Transparent,
            )
        ) {
            Text(text = "Customer", color = if (selectedButton == "Customer") Color(android.graphics.Color.parseColor("#FFFFFF")) else Color.Black)
        }
        Button(
            onClick = { selectedButton = "Chef" },
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(android.graphics.Color.parseColor("#000000")),
                containerColor = if (selectedButton == "Chef") Color(android.graphics.Color.parseColor("#50C878")) else Color.Transparent,
            )
        ) {
            Text(text = "Chef", color = if (selectedButton == "Chef") Color(android.graphics.Color.parseColor("#FFFFFF")) else Color.Black,)
        }
    }
}

@Composable
fun EditNumberField(
    modifier: Modifier = Modifier,
    value: String,
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int? = null,
    onValueChange: (String) -> Unit,
//        placeholder: @Composable () -> Unit,
    placeholder: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions
){
    OutlinedTextField(
        value,
        onValueChange,
        singleLine = true,
        label = { Text(stringResource(label)) },
        leadingIcon = {
            // Only add the leadingIcon if it's not null
            leadingIcon?.let {
                Icon(painter = painterResource(id = it), contentDescription = null)
            }
        },
        placeholder = placeholder,
        keyboardOptions = keyboardOptions,
        modifier = modifier,
//            shape = RoundedCornerShape(32.dp)
    )
}



@Preview
@Composable
fun SignInScreenPreview(){
    SignInScreen(){}
}

