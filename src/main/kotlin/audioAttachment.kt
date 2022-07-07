class audioAttachment (
    val id: Int = 1,
   val albumId: Int = 1,
    val ownerId: Int = 1,
    val userId: Int = 1,
):Attachment{
    override val type: String = "photo"
        }