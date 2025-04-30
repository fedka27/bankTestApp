package com.example.test_1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ComposeTestScreen() {
    // Test 1
    var counter by remember { mutableStateOf(0) }
    
    LaunchedEffect(key1 = counter) {
    }

    // Test 2
    SideEffect {
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Test 3
        Button(
            onClick = { 
                counter++
            }
        ) {
            Text("Increase counter: $counter")
        }

        // Test 4
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            onValueChange = { newValue ->
                // Validate input (email, phone, etc.)
                text = newValue
            },
            label = { Text("Enter text") }
        )

        // Test 5
        val isTextLong by remember(text) {
            derivedStateOf { text.length > 10 }
        }
        
        if (isTextLong) {
            Text("Text so long. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
        }

        // Test 6
        var savedText by rememberSaveable { mutableStateOf("") }
        OutlinedTextField(
            value = savedText,
            onValueChange = { savedText = it },
            label = { Text("Текст сохранится при конфигурационных изменениях") }
        )
    }
}

// Test 7
@Stable
data class User(
    val name: String,
    val age: Int
)

// Test 8
@Composable
fun RememberLambdaTest() {
    val onClick = remember {
        { /* handle click */ }
    }
    
    Button(onClick = onClick) {
        Text("Test lyambda")
    }
}

