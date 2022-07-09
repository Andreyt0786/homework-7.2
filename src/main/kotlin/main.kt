import java.util.*


fun main() {
    val commentToWall = CommentToWall(5, true, true, false, false)
    val commentToWall2 = CommentToWall(1, false, false, false, false)
    val commentToWall3 = CommentToWall(1, true, true, true, true)

    val post = Post(
        5, 1, 2, 1, 356, "Super",
        3, 1, false, commentToWall, arrayOf(audioAttachment(), videoAttachment())
    )
    val post2 = Post(
        1, 3, 2, 1, 35, "Super",
        3, 1, false, commentToWall, arrayOf(audioAttachment(), videoAttachment())
    )
    val post3 = Post(
        1, 55, 2, 1, 35, "Super",
        3, 1, false, commentToWall, arrayOf(audioAttachment(), videoAttachment())
    )
    val post4 = Post(
        6, 9, 2, 1, 35, "Super",
        3, 1, false, commentToWall, arrayOf(audioAttachment(), videoAttachment())
    )
    val postTest = Post(
        3, 222, 2, 1, 35, "Super",
        3, 1, false, commentToWall, arrayOf(audioAttachment(), videoAttachment())
    )

    // Убрано для проверки тестов
    println(WallService.add(post2))
    println(WallService.add(post))
    println(WallService.add(post3))
    println(WallService.add(post4))
    println(WallService.createComment(2, commentToWall2))
    println(WallService.createComment(3, commentToWall))
    println(WallService.createComment(15, commentToWall3))

    //print(WallService.update(postTest))

}

class PostNotFounException(message: String) : RuntimeException(message)


data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createBy: Int,
    val date: Int,
    val text: String? = null,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendOnly: Boolean,
    val commentToWall: CommentToWall,
    val attachements: Array<Attachment>
)

data class CommentToWall(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)


object WallService { // object заменен на class  для проверки тестов
    var posts = emptyArray<Post>()
    private var comments = emptyArray<CommentToWall>()

    fun add(post: Post): Post {
        if (posts?.isEmpty() ?: true) {
            posts += post
        } else {
            val (id) = posts.last()
            val idSpecial = post.copy(id = id + 1)
            posts += idSpecial
        }
        return posts.last()
    }


    fun update(post: Post): Boolean {
        var updateTrue = false
        val (id) = post
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                updateTrue = true
                posts[index] = post.copy(
                    ownerId = post.ownerId,
                    fromId = post.fromId,
                    createBy = post.createBy,
                    date = post.date,
                    text = post.text,
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendOnly = post.friendOnly,
                    commentToWall = post.commentToWall
                )
            }
        }
        return updateTrue
    }

    fun createComment(postId: Int, comment: CommentToWall): CommentToWall {
        var x = 0
        for (post in posts) {
            if (post.id == postId) {
                comments += comment
                x++
            }
        }
        if (x == 0) {
            throw PostNotFounException("Post with id = $postId  is not found")
        }
            return comments.last()
        }
    }







