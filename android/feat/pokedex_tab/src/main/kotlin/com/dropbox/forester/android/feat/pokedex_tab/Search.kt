package com.dropbox.forester.android.feat.pokedex_tab

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.dropbox.forester.android.dig.Dig

@Composable
fun Search() {

    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = text,
        leadingIcon = {
            Icon(
                painterResource(R.drawable.search),
                null,
                tint = Dig.Colors.standard.text,
                modifier = Modifier.size(32.dp)
            )
        },
        onValueChange = { newText ->
            text = newText
        },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = Dig.Colors.secondary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )

    )
}
