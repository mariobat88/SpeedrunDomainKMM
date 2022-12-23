import SwiftUI
import di
import test

@main
struct iOSApp: App {

    init() {
        HelperKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
