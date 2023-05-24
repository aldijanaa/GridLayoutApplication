package com.example.gridlayoutapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridlayoutapplication.ui.theme.GridLayoutApplicationTheme
import com.example.gridlayoutapplication.ui.theme.data.DataSource.topics
import com.example.gridlayoutapplication.ui.theme.data.DataSource
import com.example.gridlayoutapplication.ui.theme.model.Topic


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridLayoutApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Topics()
                }
            }
        }
    }
}


@Composable
fun Topics() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
    ){
        items( DataSource.topics){ topic ->
            TopicCard(topic)
        }

    }

}


@Composable
fun TopicCard( topic: Topic, modifier: Modifier = Modifier){
    Card{
        Row {
            Image(
                painter = painterResource(topic.image),
                contentDescription = null,
                modifier = modifier
                    .size(width = 68.dp, height = 68.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )

            Column{
                Text(
                    text = stringResource(topic.title),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    )

                )

                Row {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_medium)))



                    Text(
                        text = topic.number.toString(),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                    )


                }

            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GridLayoutApplicationTheme{
        Topics()
    }

    }

