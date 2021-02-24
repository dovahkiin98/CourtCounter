package net.inferno.courtcounter.layout

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.inferno.courtcounter.R
import net.inferno.courtcounter.theme.AppTheme
import java.util.*

@Composable
fun MainActivity(
) {
    var team1Score by rememberSaveable(null, key = "team1Score") { mutableStateOf(0) }
    var team2Score by rememberSaveable(null, key = "team2Score") { mutableStateOf(0) }

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
        LazyColumn {
            item {
                Row(
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
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
                                team1Score += 2
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
                                team1Score += 3
                            }
                        ) {
                            Text(
                                text = stringResource(R.string.plus3).toUpperCase(Locale.getDefault()),
                                color = Color.White,
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(vertical = 8.dp)
                            .fillMaxHeight()
                            .width(1.dp)
                            .background(MaterialTheme.colors.onSurface.copy(alpha = 0.12f))
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
                                team2Score += 2
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
                                team2Score += 3
                            }
                        ) {
                            Text(
                                text = stringResource(R.string.plus3).toUpperCase(Locale.getDefault()),
                                color = Color.White,
                            )
                        }
                    }
                }
            }
            item {
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
                        team1Score = 0
                        team2Score = 0
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
}

@Preview(
    showSystemUi = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun MainActivityPreview() {
    AppTheme(isDarkTheme = false) {
        MainActivity()
    }
}

@Preview(
    showSystemUi = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun MainActivityPreviewDark() {
    AppTheme(isDarkTheme = true) {
        MainActivity()
    }
}