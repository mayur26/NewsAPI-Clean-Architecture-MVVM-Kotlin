package com.mayur.androidcleanarchitecturemvvm.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mayur.androidcleanarchitecturemvvm.domain.model.Article
import com.mayur.androidcleanarchitecturemvvm.domain.model.ArticleData
import com.mayur.androidcleanarchitecturemvvm.ui.view.ArticleDetailScreen
import com.mayur.androidcleanarchitecturemvvm.ui.view.NewsListScreen

@Composable
fun NewsNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "news_list"
    ) {
        composable("news_list") {
            NewsListScreen(
                onArticleClick = { article ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("selected_article", article)
                    navController.navigate("article_detail")
                }
            )
        }

        composable("article_detail") {
            val article = navController.previousBackStackEntry?.savedStateHandle?.get<ArticleData>("selected_article")
            article?.let {
                ArticleDetailScreen(
                    article = it,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}
