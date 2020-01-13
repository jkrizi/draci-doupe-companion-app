import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {WeaponBlueprintComponent} from './forms/item-blueprints/weapon-blueprint/weapon-blueprint.component';
import {ArmorBlueprintComponent} from './forms/item-blueprints/armor-blueprint/armor-blueprint.component';
import {GoodsBlueprintComponent} from './forms/item-blueprints/goods-blueprint/goods-blueprint.component';
import {TreasureBlueprintComponent} from './forms/item-blueprints/treasure-blueprint/treasure-blueprint.component';
import {PersonBlueprintComponent} from './forms/character-blueprints/person-blueprint/person-blueprint.component';
import {BeastBlueprintComponent} from './forms/character-blueprints/beast-blueprint/beast-blueprint.component';
import {SkillComponent} from './forms/skill/skill.component';
import {RaceComponent} from './forms/race/race.component';
import {SpellFormComponent} from './forms/spell-form/spell-form.component';
import {SwordPlayMoveComponent} from './forms/sword-play-move/sword-play-move.component';
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

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    WeaponBlueprintComponent,
    ArmorBlueprintComponent,
    GoodsBlueprintComponent,
    TreasureBlueprintComponent,
    PersonBlueprintComponent,
    BeastBlueprintComponent,
    SkillComponent,
    RaceComponent,
    SpellFormComponent,
    SwordPlayMoveComponent,
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
