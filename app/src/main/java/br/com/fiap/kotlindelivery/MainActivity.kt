package br.com.fiap.kotlindelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.kotlindelivery.ui.theme.KotlinDeliveryTheme
import br.com.fiap.kotlindelivery.ui.theme.Purple500
import br.com.fiap.kotlindelivery.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinDeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductSection()
                }
            }
        }
    }
}

@Composable
fun ProductItem() {
    Column(
        modifier = Modifier
            .height(250.dp)
            .width(250.dp)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .background(brush = Brush.horizontalGradient(colors = listOf(Purple500, Teal200)))
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                Modifier
                    .size(100.dp)
                    .offset(y = 50.dp)
                    .clip(shape = CircleShape)
                    .align(BottomCenter)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = LoremIpsum(50).values.first(),
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(text = "Texto 2")
        }

    }
}

@Composable
fun ProductSection() {
    Column() {
        Text(text = "Promoções do dia!")
        Row {
            ProductItem()
            ProductItem()
            ProductItem()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductSectionPreview() {
    ProductSection()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductItemPreview() {
    KotlinDeliveryTheme {
        ProductItem()
    }
}