import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {WeaponBlueprintFormComponent} from './forms/item-blueprints/weapon-blueprint-form/weapon-blueprint-form.component';
import {ArmorBlueprintComponent} from './forms/item-blueprints/armor-blueprint/armor-blueprint.component';
import {GoodsBlueprintComponent} from './forms/item-blueprints/goods-blueprint/goods-blueprint.component';
import {TreasureBlueprintComponent} from './forms/item-blueprints/treasure-blueprint/treasure-blueprint.component';
import {PersonBlueprintComponent} from './forms/character-blueprints/person-blueprint/person-blueprint.component';
import {BeastBlueprintComponent} from './forms/character-blueprints/beast-blueprint/beast-blueprint.component';
import {SkillFormComponent} from './forms/skill-form/skill-form.component';
import {RaceFormComponent} from './forms/race-form/race-form.component';
import {SpellFormComponent} from './forms/spell-form/spell-form.component';
import {SwordMoveFormComponent} from './forms/sword-move-form/sword-move-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {InputComponent} from './features/input/input.component';
import {FormControlsComponent} from './controls/form-controls/form-controls.component';
import {NavbarInputComponent} from './navbar/navbar-input/navbar-input.component';
import {GeneratorComponent} from './features/generator/generator.component';
import {CalculatorComponent} from './features/calculator/calculator.component';
import {BattlegroundComponent} from './features/battleground/battleground.component';
import {ShopComponent} from './features/shop/shop.component';
import {ItemBlueprintComponent} from './forms/item-blueprints/item-blueprint.component';
import { AbilitiesComponent } from './forms/character-blueprints/abilities/abilities.component';
import { CombatValuesComponent } from './forms/character-blueprints/combat-values/combat-values.component';
import {AppRoutingModule} from './app-routing.module';
import { InventoryComponent } from './forms/character-blueprints/inventory/inventory.component';
import { BeastBlueprintListComponent } from './lists/beast-blueprint-list/beast-blueprint-list.component';
import { SpellListComponent } from './lists/spell-list/spell-list.component';
import { SpellInputComponent } from './features/input/spell-input/spell-input.component';
import { SkillListComponent } from './lists/skill-list/skill-list.component';
import {SkillInputComponent} from './features/input/skill-input/skill-input.component';
import { SwordMoveInputComponent } from './features/input/sword-move-input/sword-move-input.component';
import { SwordMoveListComponent } from './lists/sword-move-list/sword-move-list.component';
import { BeastBlueprintInputComponent } from './features/input/beast-blueprint-input/beast-blueprint-input.component';
import { RaceInputComponent } from './features/input/race-input/race-input.component';
import { RaceListComponent } from './lists/race-list/race-list.component';
import { WeaponBlueprintListComponent } from './lists/weapon-blueprint-list/weapon-blueprint-list.component';
import { WeaponBlueprintInputComponent } from './features/input/weapon-blueprint-input/weapon-blueprint-input.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    WeaponBlueprintFormComponent,
    ArmorBlueprintComponent,
    GoodsBlueprintComponent,
    TreasureBlueprintComponent,
    PersonBlueprintComponent,
    BeastBlueprintComponent,
    SkillFormComponent,
    RaceFormComponent,
    SpellFormComponent,
    SwordMoveFormComponent,
    InputComponent,
    FormControlsComponent,
    NavbarInputComponent,
    GeneratorComponent,
    CalculatorComponent,
    BattlegroundComponent,
    ShopComponent,
    ItemBlueprintComponent,
    AbilitiesComponent,
    CombatValuesComponent,
    InventoryComponent,
    BeastBlueprintListComponent,
    SpellListComponent,
    SpellInputComponent,
    SkillListComponent,
    SkillInputComponent,
    SwordMoveInputComponent,
    SwordMoveListComponent,
    BeastBlueprintInputComponent,
    RaceInputComponent,
    RaceListComponent,
    WeaponBlueprintListComponent,
    WeaponBlueprintInputComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
