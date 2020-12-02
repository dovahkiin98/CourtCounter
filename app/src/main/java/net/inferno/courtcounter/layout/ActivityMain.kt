package net.inferno.courtcounter.layout

import android.content.res.Configuration
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Devices
import androidx.ui.tooling.preview.Preview
import net.inferno.courtcounter.R
import net.inferno.courtcounter.theme.AppTheme
import net.inferno.courtcounter.viewModel.MainViewModel
import java.util.*

@OptIn(ExperimentalLayout::class)
@Composable
fun mainActivity(
    mainViewModel: MainViewModel = viewModel()
) {
    val team1Score by mainViewModel.firstTeam.observeAsState()
    val team2Score by mainViewModel.secondTeam.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth()
                )
            }
        },
    ) {
        ScrollableColumn {
            Row(
                modifier = Modifier
                    .preferredHeight(IntrinsicSize.Max)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = stringResource(R.string.team_1),
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(top = 16.dp)
                    )
                    Text(
                        text = team1Score.toString(),
                        fontSize = 60.sp,
                        modifier = Modifier
                            .padding(top = 16.dp),
                    )
                    Button(
                        modifier = Modifier
                            .padding(
                                top = 4.dp,
                                bottom = 8.dp,
                            )
                            .padding(top = 16.dp),
                        onClick = {
                            mainViewModel.addScore(0, 2)
                        },
                    ) {
                        Text(
                            text = stringResource(R.string.plus2).toUpperCase(Locale.getDefault()),
                            color = Color.White,
                        )
                    }
                    Button(
                        modifier = Modifier
                            .padding(
                                top = 4.dp,
                                bottom = 8.dp,
                            )
                            .padding(
                                top = 16.dp,
                                bottom = 8.dp,
                            ),
                        onClick = {
                            mainViewModel.addScore(0, 3)
                        }
                    ) {
                        Text(
                            text = stringResource(R.string.plus3).toUpperCase(Locale.getDefault()),
                            color = Color.White,
                        )
                    }
                }
                Divider(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(vertical = 8.dp)
                        .fillMaxHeight()
                        .width(1.dp)
                        .background(MaterialTheme.colors.onSurface.copy(alpha = 0.12f)),
                )
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = stringResource(R.string.team_2),
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(top = 16.dp)
                    )
                    Text(
                        text = team2Score.toString(),
                        fontSize = 60.sp,
                        modifier = Modifier
                            .padding(top = 16.dp),
                    )
                    Button(
                        modifier = Modifier
                            .padding(
                                top = 4.dp,
                                bottom = 8.dp,
                            )
                            .padding(top = 16.dp),
                        onClick = {
                            mainViewModel.addScore(1, 2)
                        },
                    ) {
                        Text(
                            text = stringResource(R.string.plus2).toUpperCase(Locale.getDefault()),
                            color = Color.White,
                        )
                    }
                    Button(
                        modifier = Modifier
                            .padding(
                                top = 4.dp,
                                bottom = 8.dp,
                            )
                            .padding(
                                top = 16.dp,
                                bottom = 8.dp,
                            ),
                        onClick = {
                            mainViewModel.addScore(1, 3)
                        }
                    ) {
                        Text(
                            text = stringResource(R.string.plus3).toUpperCase(Locale.getDefault()),
                            color = Color.White,
                        )
                    }
                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 4.dp,
                        bottom = 8.dp,
                    )
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp),
                onClick = {
                    mainViewModel.resetScores()
                },
            ) {
                Text(
                    text = stringResource(R.string.reset).toUpperCase(Locale.getDefault()),
                    color = Color.White,
                )
            }
        }
    }
}

@Preview(
    showDecoration = true,
    device = Devices.NEXUS_5,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun mainActivityPreviewLight() {
    AppTheme {
        mainActivity(MainViewModel())
    }
}