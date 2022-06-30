import java.awt.desktop.PrintFilesEvent
import java.sql.DriverManager.println

fun main() {
    val commentToWall = CommentToWall(5, true, true, false, false)

    val post = Post(
        1, 1, 2, 1, 356, "Super",
        3, 1, false, commentToWall
    )
    val post2 = Post(
        1, 1, 2, 1, 35, "Super",
        3, 1, false, commentToWall
    )
    WallService.add(post2)
    WallService.add(post)



}



data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendOnly: Boolean,
    val commentToWall: CommentToWall
)

data class CommentToWall(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

object WallService {
    var posts = emptyArray<Post>()
    fun add(post: Post) {
        posts += post
        
        println(posts.last())
    }

}




