package com.hfad.mycountcompose.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hfad.mycountcompose.R
import com.hfad.mycountcompose.ui.theme.MyCountComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Composable
fun MyApp(viewModel: CountViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    MyCountApp(uiState = uiState,
        plus = viewModel::plus, minus = viewModel::minus,
//        saveItem = { coroutineScope.launch { viewModel.saveItem() }}
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCountApp(
    uiState: CountUiState,
    plus: () -> Unit, minus: () -> Unit
//    saveItem:()->Unit
) {
    //запоминает состояние для BottomSheet
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "sds", maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                },
                navigationIcon = {
                    IconButton(onClick = { showBottomSheet = true }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = uiState.count.toString(), fontSize = 50.sp
            )
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.minuse),
                    contentDescription = null,
                    modifier = Modifier
                        .height(177.dp)
                        .width(170.dp)
                        .clickable {
//                            saveItem()
                            minus() },

                    contentScale = ContentScale.Fit
                )

                Image(
                    painter = painterResource(id = R.drawable.plus), contentDescription = null,
                    modifier = Modifier
                        .height(177.dp)
                        .width(170.dp)
                        .clickable {
//                            saveItem()
                            plus() },
                    contentScale = ContentScale.Fit
                )
            }
        }
        if (showBottomSheet) {
            BottomSheet(false, scope, sheetState)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(showBottomSheet: Boolean, scope: CoroutineScope, sheetState: SheetState) {
    ModalBottomSheet(
        onDismissRequest = { showBottomSheet },
        sheetState = sheetState
    ) {
        Button(onClick = {
            scope.launch { sheetState.hide() }.invokeOnCompletion {
                if (!sheetState.isVisible) {
                    showBottomSheet
                }
            }
        }) {
            Text("Hide bottom sheet")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCountComposeTheme {
        MyApp()
    }
}