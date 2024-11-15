import { Routes } from '@angular/router';
import { MainComponent } from './components/layout/main/main.component';
import { DashboardComponent } from './components/layout/dashboard/dashboard.component';

export const routes: Routes = [
    { path: '', redirectTo: 'main/dashboard', pathMatch: 'full' },
    { path: 'main', component: MainComponent, children: [
        { path: 'dashboard', component: DashboardComponent }
    ]}

];
