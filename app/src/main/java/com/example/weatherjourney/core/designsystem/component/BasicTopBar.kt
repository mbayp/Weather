package com.example.weatherjourney.core.designsystem.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.weatherjourney.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicTopBar(title: String, onBackClick: () -> Unit, modifier: Modifier = Modifier) {
    TopAppBar(
        navigationIcon = {
            IconButton(onBackClick) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                )
            }
        },
        title = {
            Text(
                title,
                style = MaterialTheme.typography.titleMedium,
            )
        },
        modifier = modifier,
    )
}
