package com.example.register.ui.screens

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.register.DatabaseHelper
import com.example.register.ui.theme.RegisterTheme
import kotlinx.coroutines.delay

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, onNavigateToRegister: () -> Unit) {
    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    
    var loginAttempts by remember { mutableIntStateOf(0) }
    var errorMessage by remember { mutableStateOf("") }
    var showVerifyDialog by remember { mutableStateOf(false) }
    
    val context = LocalContext.current
    val db = remember { DatabaseHelper(context) }

    // TIMER 5 DETIK
    LaunchedEffect(isPasswordVisible) {
        if (isPasswordVisible) {
            delay(5000)
            isPasswordVisible = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(bottom = 8.dp))
        }

        OutlinedTextField(
            value = usernameInput,
            onValueChange = { usernameInput = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            label = { Text("Password") },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = "Tampilkan Password"
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val user = usernameInput.trim()
                val pass = passwordInput.trim()
                if (db.checkUser(user, pass)) {
                    Toast.makeText(context, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                    onLoginSuccess()
                } else {
                    loginAttempts++
                    if (loginAttempts >= 3) showVerifyDialog = true
                    else errorMessage = "Gagal login ($loginAttempts/3)"
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = loginAttempts < 3
        ) {
            Text("Login")
        }

        TextButton(onClick = { onNavigateToRegister() }) {
            Text("Belum punya akun? Register")
        }

        if (showVerifyDialog) {
            AlertDialog(
                onDismissRequest = { },
                title = { Text("Verifikasi") },
                text = { Text("Salah 3 kali. Hubungi Gmail.") },
                confirmButton = {
                    Button(onClick = {
                        val intent = Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:support@example.com")
                            putExtra(Intent.EXTRA_SUBJECT, "Buka Kunci Akun: $usernameInput")
                        }
                        context.startActivity(intent)
                        loginAttempts = 0
                        showVerifyDialog = false
                        errorMessage = ""
                    }) { Text("Buka Gmail") }
                }
            )
        }
    }
}
