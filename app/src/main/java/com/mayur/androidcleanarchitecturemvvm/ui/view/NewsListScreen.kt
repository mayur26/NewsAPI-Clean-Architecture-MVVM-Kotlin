package com.mayur.androidcleanarchitecturemvvm.ui.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mayur.androidcleanarchitecturemvvm.domain.model.Article
import com.mayur.androidcleanarchitecturemvvm.domain.model.ArticleData
import com.mayur.androidcleanarchitecturemvvm.ui.components.ArticleCard
import com.mayur.androidcleanarchitecturemvvm.ui.components.ErrorScreen
import com.mayur.androidcleanarchitecturemvvm.ui.components.LoadingScreen
import com.mayur.androidcleanarchitecturemvvm.ui.viewmodel.NewsViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListScreen(
    onArticleClick: (ArticleData) -> Unit,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    var showSearchBar by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            if (showSearchBar) {
                SearchTopBar(
                    query = searchQuery,
                    onQueryChange = { viewModel.searchNews(it) },
                    onCloseSearch = {
                        showSearchBar = false
                        viewModel.searchNews("")
                    }
                )
            } else {
                TopAppBar(
                    title = {
                        Text(
                            text = "Latest News",
                            style = MaterialTheme.typography.headlineMedium
                        )
                    },
                    actions = {
                        IconButton(
                            onClick = { showSearchBar = true }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = Color.White
                    )
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                uiState.isLoading -> {
                    LoadingScreen()
                }
                uiState.error != null -> {
                    ErrorScreen(
                        message = "MAYUR",
                        onRetryClick = { viewModel.refresh() }
                    )
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(uiState.articles) { article ->
                            ArticleCard(
                                article = article,
                                onClick = { onArticleClick(article) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchTopBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onCloseSearch: () -> Unit
) {
    TopAppBar(
        title = {
            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                placeholder = { Text("Search news...") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White.copy(alpha = 0.7f),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedPlaceholderColor = Color.White.copy(alpha = 0.7f),
                    unfocusedPlaceholderColor = Color.White.copy(alpha = 0.5f)
                )
            )
        },
        navigationIcon = {
            TextButton(
                onClick = onCloseSearch
            ) {
                Text(
                    text = "Cancel",
                    color = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}
