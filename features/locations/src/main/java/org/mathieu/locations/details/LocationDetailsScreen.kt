package org.mathieu.locations.details

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.mathieu.ui.composables.LocationCard
import org.mathieu.ui.composables.PreviewContent

@Composable
fun LocationDetailsScreen(
    navController: NavController,
    id: Int
) {
    val viewModel: LocationDetailsViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    viewModel.init(locationId = id)

    LocationDetailsContent(
        state = state,
        onClickBack = { navController.popBackStack() }
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
private fun LocationDetailsContent(
    state: LocationDetailsState = LocationDetailsState(),
    onClickBack: () -> Unit = {}
) {
    Scaffold(topBar = {

        Row(
            modifier = Modifier
                .background(org.mathieu.ui.theme.Purple40)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable(onClick = onClickBack),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White)
            )

            Text(
                text = state.location?.name ?: "",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues), contentAlignment = Alignment.Center) {
            AnimatedContent(targetState = state.error != null, label = "") {
                state.error?.let { error ->
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = error,
                        textAlign = TextAlign.Center,
                        color = org.mathieu.ui.theme.Purple40,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 36.sp
                    )
                } ?: Box(modifier = Modifier.fillMaxSize()) {

                    Box(Modifier.align(Alignment.TopCenter)) {

                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(
                                    Brush.verticalGradient(
                                        listOf(
                                            Color.Transparent,
                                            MaterialTheme.colorScheme.background
                                        )
                                    )
                                )
                        )
                    }

                    Column(
                        modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (state.location != null) {
                            LocationCard(
                                location = state.location,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun LocationDetailsPreview() = PreviewContent {
    LocationDetailsContent()
}