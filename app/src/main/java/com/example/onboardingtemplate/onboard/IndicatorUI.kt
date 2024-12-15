import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IndicatorUi(
    pageSize: Int,
    currentPage: Int,
    selectedColor: Color = Color(android.graphics.Color.parseColor("#4CAF50")),
    unselectedColor: Color = Color(android.graphics.Color.parseColor("#A0E67E"))
) {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize) { index ->
            Spacer(modifier = Modifier.size(2.5.dp))
            val customEasing = Easing { fraction -> fraction * fraction * (3 - 2 * fraction) }


            // Use labeled animations for easier inspection in Animation Preview
            val width by animateDpAsState(
                targetValue = if (index == currentPage) 32.dp else 14.dp,
                animationSpec = TweenSpec(durationMillis = 500, easing = FastOutSlowInEasing),
                label = "IndicatorWidth-$index"
            )
            val color by animateColorAsState(
                targetValue = if (index == currentPage) selectedColor else unselectedColor,
                label = "IndicatorColor-$index",
                animationSpec = TweenSpec(durationMillis = 500, easing = customEasing)
            )
            Box(
                modifier = Modifier
                    .height(14.dp)
                    .width(width)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color)
            )

            Spacer(modifier = Modifier.size(2.5.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndicatorUIPreview1() {
    IndicatorUi(pageSize = 3, currentPage = 0)
}

@Preview(showBackground = true)
@Composable
fun IndicatorUIPreview2() {
    IndicatorUi(pageSize = 3, currentPage = 1)
}

@Preview(showBackground = true)
@Composable
fun IndicatorUIPreview3() {
    IndicatorUi(pageSize = 3, currentPage = 2)
}
