import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {WeaponBlueprintFormComponent} from './features/input/form/item-blueprint-form/weapon-blueprint-form/weapon-blueprint-form.component';
import {ArmorBlueprintFormComponent} from './features/input/form/item-blueprint-form/armor-blueprint-form/armor-blueprint-form.component';
import {GoodsBlueprintFormComponent} from './features/input/form/item-blueprint-form/goods-blueprint-form/goods-blueprint-form.component';
import {TreasureBlueprintFormComponent} from './features/input/form/item-blueprint-form/treasure-blueprint-form/treasure-blueprint-form.component';
import {PersonBlueprintFormComponent} from './features/input/form/character-blueprint-form/person-blueprint-form/person-blueprint-form.component';
import {BeastBlueprintFormComponent} from './features/input/form/character-blueprint-form/beast-blueprint-form/beast-blueprint-form.component';
import {SkillFormComponent} from './features/input/form/skill-form/skill-form.component';
import {RaceFormComponent} from './features/input/form/race-form/race-form.component';
import {SpellFormComponent} from './features/input/form/spell-form/spell-form.component';
import {SwordMoveFormComponent} from './features/input/form/sword-move-form/sword-move-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {InputComponent} from './features/input/input.component';
import {FormControlsComponent} from './features/input/form-controls/form-controls.component';
import {NavbarInputComponent} from './navbar/navbar-input/navbar-input.component';
import {GeneratorComponent} from './features/generator/generator.component';
import {CalculatorComponent} from './features/calculator/calculator.component';
import {BattlegroundComponent} from './features/battleground/battleground.component';
import {ShopComponent} from './features/shop/shop.component';
import {ItemBlueprintComponent} from './features/input/form/item-blueprint-form/item-blueprint.component';
import {AbilitiesComponent} from './features/input/form/character-blueprint-form/abilities-form/abilities-form.component';
import {CombatValuesComponent} from './features/generator/combat-values/combat-values.component';
import {AppRoutingModule} from './app-routing.module';
import {InventoryComponent} from './features/input/form/character-blueprint-form/blueprint-inventory-form/blueprint-inventory-form.component';
import {BeastBlueprintListComponent} from './features/input/list/beast-blueprint-list/beast-blueprint-list.component';
import {SpellListComponent} from './features/input/list/spell-list/spell-list.component';
import {SpellInputComponent} from './features/input/container/spell-input/spell-input.component';
import {SkillListComponent} from './features/input/list/skill-list/skill-list.component';
import {SkillInputComponent} from './features/input/container/skill-input/skill-input.component';
import {SwordMoveInputComponent} from './features/input/container/sword-move-input/sword-move-input.component';
import {SwordMoveListComponent} from './features/input/list/sword-move-list/sword-move-list.component';
import {BeastBlueprintInputComponent} from './features/input/container/beast-blueprint-input/beast-blueprint-input.component';
import {RaceInputComponent} from './features/input/container/race-input/race-input.component';
import {RaceListComponent} from './features/input/list/race-list/race-list.component';
import {WeaponBlueprintListComponent} from './features/input/list/weapon-blueprint-list/weapon-blueprint-list.component';
import {WeaponBlueprintInputComponent} from './features/input/container/weapon-blueprint-input/weapon-blueprint-input.component';
import {ArmorBlueprintInputComponent} from './features/input/container/armor-blueprint-input/armor-blueprint-input.component';
import {ArmorBlueprintListComponent} from './features/input/list/armor-blueprint-list/armor-blueprint-list.component';
import {GoodsBlueprintInputComponent} from './features/input/container/goods-blueprint-input/goods-blueprint-input.component';
import {TreasureBlueprintInputComponent} from './features/input/container/treasure-blueprint-input/treasure-blueprint-input.component';
import {GoodsBlueprintListComponent} from './features/input/list/goods-blueprint-list/goods-blueprint-list.component';
import {TreasureBlueprintListComponent} from './features/input/list/treasure-blueprint-list/treasure-blueprint-list.component';
import {GemstoneBlueprintFormComponent} from './features/input/form/item-blueprint-form/treasure-blueprint-form/gemstone-blueprint-form/gemstone-blueprint-form.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { WeaponFamilyFormComponent } from './features/input/form/item-blueprint-form/weapon-blueprint-form/weapon-family-form/weapon-family-form.component';
import {PersonBlueprintInputComponent} from './features/input/container/person-blueprint-input/person-blueprint-input.component';
import {PersonBlueprintListComponent} from './features/input/list/person-blueprint-list/person-blueprint-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    WeaponBlueprintFormComponent,
    ArmorBlueprintFormComponent,
    GoodsBlueprintFormComponent,
    TreasureBlueprintFormComponent,
    BeastBlueprintFormComponent,
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
    ArmorBlueprintInputComponent,
    ArmorBlueprintListComponent,
    GoodsBlueprintInputComponent,
    TreasureBlueprintInputComponent,
    GoodsBlueprintListComponent,
    TreasureBlueprintListComponent,
    GemstoneBlueprintFormComponent,
    WeaponFamilyFormComponent,
    PersonBlueprintInputComponent,
    PersonBlueprintFormComponent,
    PersonBlueprintListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [
    GemstoneBlueprintFormComponent,
    WeaponFamilyFormComponent
  ]
})
export class AppModule {
}
