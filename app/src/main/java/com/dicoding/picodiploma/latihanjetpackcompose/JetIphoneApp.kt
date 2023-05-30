package com.dicoding.picodiploma.latihanjetpackcompose
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dicoding.picodiploma.latihanjetpackcompose.model.Iphone
import com.dicoding.picodiploma.latihanjetpackcompose.model.IphoneData.iphone
import com.dicoding.picodiploma.latihanjetpackcompose.ui.theme.LatihanJetpackComposeTheme

@Composable
fun IphoneListItem(context:Context,
    iphone : Iphone,
    modifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable {
            val intentToDetailPage = Intent(context, DetailActivity::class.java)
            intentToDetailPage.putExtra("iphoneDetail", iphone)
            context.startActivity(intentToDetailPage)
        }
    ) {
        AsyncImage(
            model = iphone.photoUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(
            text = iphone.name,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp)
        )
    }
}

@Composable
fun JetIphoneApp(
    modifier: Modifier = Modifier, context: Context,
) {
    Box(modifier = modifier) {
        LazyColumn {
            items(iphone, key={it.name}) {
                IphoneListItem(
                    iphone = it,
                    modifier = Modifier
                        .fillMaxWidth(), context = context

                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun JetIphoneAppPreview() {
    LatihanJetpackComposeTheme {
        JetIphoneApp(context= LocalContext.current)
    }
}

