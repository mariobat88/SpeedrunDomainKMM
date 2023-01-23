import SwiftUI
import di
import database
import app
import dashboard

@main
struct iOSApp: App{

    let appComponent: AppComponent = AppComponentImpl(databaseDriverFactory: DatabaseDatabaseDriverFactory())
    let appViewModel = AppViewModel.companion.create()
    
	var body: some Scene {
		WindowGroup {
            MyFeatureScreen(dashboardNavigator: appViewModel)
		}
	}
}
