@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.novo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import com.example.novo.ui.theme.NovoTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun BottomAppBarDefaults (){
    Column {
        Row {
            BottomAppBar(

                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Check, contentDescription = "Localized description")
                    }
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description",
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* do something */ },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, "Localized description")
                    }
                })


        }

        Column {

            // define dependent checkboxes states
            val (state, onStateChange) = remember { mutableStateOf(true) }
            val (state2, onStateChange2) = remember { mutableStateOf(true) }

            // TriStateCheckbox state reflects state of dependent checkboxes
            val parentState = remember(state, state2) {
                if (state && state2) ToggleableState.On
                else if (!state && !state2) ToggleableState.Off
                else ToggleableState.Indeterminate
            }
            // click on TriStateCheckbox can set state for dependent checkboxes
            val onParentClick = {
                val s = parentState != ToggleableState.On
                onStateChange(s)
                onStateChange2(s)
            }

            ListItem(
                headlineText = { Text("02-05-2005") },
                supportingText = { Text("Nicoly's birth") },
                trailingContent = { Text("may") },
                leadingContent = {
                    TriStateCheckbox(
                        state = parentState,
                        onClick = onParentClick,
                    )
                }
            )

            ListItem(
                headlineText = { Text("03-02-2006") },
                supportingText = { Text("Julia's birth") },
                trailingContent = { Text("january") },
                leadingContent = {
                    TriStateCheckbox(
                        state = parentState,
                        onClick = onParentClick,
                    )
                }
            )

            ListItem(
                headlineText = { Text("24-08-2005") },
                supportingText = { Text("Vent's birth") },
                trailingContent = { Text("august") },
                leadingContent = {
                    TriStateCheckbox(
                        state = parentState,
                        onClick = onParentClick,
                    )
                }
            )

            ListItem(
                headlineText = { Text("20-08-2005") },
                supportingText = { Text("Kezia's birth") },
                trailingContent = { Text("august") },
                leadingContent = {
                    TriStateCheckbox(
                        state = parentState,
                        onClick = onParentClick,
                    )
                }
            )

        }





        }


    }









