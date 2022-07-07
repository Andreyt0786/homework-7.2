class videoAttachment  (
    val id: Int = 2,
    val albumId: Int = 2,
    val ownerId: Int = 2,
    val userId: Int = 2,
):Attachment{
    override val type: String = "video"
}