package fm.pangea.client

data class EnterResponse(val id:String, val result: Result, val balance: Balance, val user: User, val control:List<Control>)