@file:OptIn(ExperimentalMaterial3Api::class)

package net.inferno.courtcounter.layout

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
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
import net.inferno.courtcounter.theme.digitalFont
import java.util.*

@Composable
fun MainActivity(
) {
    var team1Score by rememberSaveable(null, key = "team1Score") { mutableStateOf(0) }
    var team2Score by rememberSaveable(null, key = "team2Score") { mutableStateOf(0) }

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )
                },
                modifier = Modifier.statusBarsPadding(),
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Max),
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = stringResource(R.string.team_1),
                        modifier = Modifier
                            .padding(top = 16.dp),
                        fontSize = 20.sp,
                    )
                    Text(
                        text = team1Score.toString(),
                        modifier = Modifier
                            .padding(top = 16.dp),
                        fontSize = 72.sp,
                        fontFamily = digitalFont,
                    )
                    Button(
                        onClick = {
                            team1Score += 2
                        },
                        modifier = Modifier
                            .padding(
                                top = 4.dp,
                                bottom = 8.dp,
                            )
                            .padding(top = 16.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.plus2).uppercase(Locale.getDefault()),
                            color = Color.White,
                        )
                    }
                    Button(
                        onClick = {
                            team1Score += 3
                        },
                        modifier = Modifier
                            .padding(
                                top = 4.dp,
                                bottom = 8.dp,
                            )
                            .padding(
                                top = 16.dp,
                                bottom = 8.dp,
                            ),
                    ) {
                        Text(
                            text = stringResource(R.string.plus3).uppercase(Locale.getDefault()),
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
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                )

                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = stringResource(R.string.team_2),
                        modifier = Modifier
                            .padding(top = 16.dp),
                        fontSize = 20.sp,
                    )
                    Text(
                        text = team2Score.toString(),
                        modifier = Modifier
                            .padding(top = 16.dp),
                        fontSize = 72.sp,
                        fontFamily = digitalFont,
                    )
                    Button(
                        onClick = {
                            team2Score += 2
                        },
                        modifier = Modifier
                            .padding(
                                top = 4.dp,
                                bottom = 8.dp,
                            )
                            .padding(top = 16.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.plus2).uppercase(Locale.getDefault()),
                            color = Color.White,
                        )
                    }
                    Button(
                        onClick = {
                            team2Score += 3
                        },
                        modifier = Modifier
                            .padding(
                                top = 4.dp,
                                bottom = 8.dp,
                            )
                            .padding(
                                top = 16.dp,
                                bottom = 8.dp,
                            ),
                    ) {
                        Text(
                            text = stringResource(R.string.plus3).uppercase(Locale.getDefault()),
                            color = Color.White,
                        )
                    }
                }
            }

            Button(
                onClick = {
                    team1Score = 0
                    team2Score = 0
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 4.dp,
                        bottom = 8.dp,
                    )
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp),
            ) {
                Text(
                    text = stringResource(R.string.reset).uppercase(Locale.getDefault()),
                    color = Color.White,
                )
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Light Theme"
)
@Composable
fun MainActivityPreview() {
    AppTheme {
        MainActivity()
    }
}

@Preview(
    showSystemUi = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Theme",
)
@Composable
fun MainActivityPreviewDark() {
    AppTheme {
        MainActivity()
    }
}