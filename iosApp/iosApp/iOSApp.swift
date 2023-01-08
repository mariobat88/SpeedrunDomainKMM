import SwiftUI
import di

@main
struct iOSApp: App{

    var appComponent: AppComponent = AppComponentImpl()
    
	var body: some Scene {
		WindowGroup {
			 MyFeatureScreen()
		}
	}
}
