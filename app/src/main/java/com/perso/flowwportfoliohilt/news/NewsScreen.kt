@file:OptIn(ExperimentalGlideComposeApi::class, ExperimentalFoundationApi::class)

package com.perso.flowwportfoliohilt.news

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.perso.flowwportfoliohilt.R
import com.perso.flowwportfoliohilt.util.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CombinedTab(viewModel: NewsViewModel) {
    val tabData = listOf(
        "HEADLINES" to "headlines",
        "GOOGLE" to "Android",
        "APPLE" to "Apple",
    )

    val pagerState = rememberPagerState(
       pageCount = tabData.size,
        initialOffscreenLimit = 2,
        infiniteLoop = true,
        initialPage = 0
    )
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(selectedTabIndex = tabIndex, indicator = { tabPositions ->
            TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pagerState, tabPositions))
        }) {
            tabData.forEachIndexed { index, pair ->
                Tab(selected = tabIndex == index, onClick = {
                   coroutineScope.launch {
                       pagerState.animateScrollToPage(index)
                   }
                }, text = {
                    Text(pair.first)
                }, enabled = true)
            }
        }

        HorizontalPager(state = pagerState) { index ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubNewsScreen(tabIndex = tabData[index].first, viewModel = viewModel)
            }
        }
    }
}

@Composable
fun NewsScreen(viewModel: NewsViewModel) {
    CombinedTab(viewModel)
}

@Composable
fun SubNewsScreen(tabIndex: String, viewModel: NewsViewModel) {

    val data = when (tabIndex) {
        "HEADLINES" -> viewModel.headlinesFlow.observeAsState()
        "GOOGLE" -> viewModel.googleNewsFlow.observeAsState()
        "APPLE" -> viewModel.appleNewsFlow.observeAsState()
        else -> {
            viewModel.headlinesFlow.observeAsState()
        }
    }
    val articles = data.value?.data?.articles
    articles?.let {
        LazyColumn(contentPadding = PaddingValues(bottom = 80.dp, start = 16.dp, end = 16.dp, top = 16.dp)) {
            items(it) { article ->
                NewsItem(title = article.title, imageUrl = article.urlToImage)
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp))
            }
        }
    }
}


@Composable
fun NewsItem(title: String?, imageUrl: String?) {
    Card(
        shape = RoundedCornerShape(8.dp), elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ), colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.DimGray),
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            title?.let {
                Text(
                    text = title,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            imageUrl?.let {
                GlideImage(
                    model = imageUrl,
                    contentDescription = title
                )
            }
        }
    }
}
