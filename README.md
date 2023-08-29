# nogle_exam
![exchange_flow_app drawio](https://github.com/ricky7777/nogle_exam/assets/3930480/e1580a6f-4f08-4b91-b80d-7c93234b9c54)

Cryptocurrency Exchanges
Please build up App according to the following description
● Android MVVM architecture (ViewModel/Repository)
● Use Retrofit + Coroutine to archive HTTP connection
● Use Navigation Component to handle page direction
● Use MediatorLiveData to combine multiple data sources
● Use Kotlin language only
● Upload source code to Github/GitLab and share signed APK

Please design UI according to the following description
- As a user, I want a Single-Activity App with BottomNavigationView that has 4 tabs A, B, C and D
```diff
+ Implement button on xml
```
● As a user, I want a Single-Activity App with BottomNavigationView that has 4 tabs A, B, C and D
● I can click tab A to view a market list with name and price on each item and sorted by name
● I can view spot/futures tabs at top of market list that I can toggle them to see list separately
● I can view a settings entrance button at top right of D page and click it to go to Settings page
● I can view the whole Settings page with no BottomNavigationView at the bottom of the screen
● I can view the page name at the center of the page except A page. So I can know where I am

Data source
● API path - https://api.btse.com/futures/api/inquire/initial/market
○ Use parameter symbol to display name
○ Use parameter future to distinguish between spot and futures
● WS path - wss://ws.btse.com/ws/futures
○ Reference https://btsecom.github.io/docs/futures/en/#subscription
○ Send {"op": "subscribe", "args": ["coinIndex"]} after socket connected
○ Refer Appendix 1 for response format
○ Use parameter type = 1 only
○ Use parameter price to display price

https://www.immigration.gov.tw/media/62712/appendix-1.pdf
