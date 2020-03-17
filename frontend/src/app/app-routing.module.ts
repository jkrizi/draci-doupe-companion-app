import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {GeneratorComponent} from './features/generator/generator.component';
import {CalculatorComponent} from './features/calculator/calculator.component';
import {BattlegroundComponent} from './features/battleground/battleground.component';
import {ShopComponent} from './features/shop/shop.component';
import {InputComponent} from './features/input/input.component';
import {SpellInputComponent} from './features/input/spell-input/spell-input.component';
import {SkillInputComponent} from './features/input/skill-input/skill-input.component';
import {SwordMoveInputComponent} from './features/input/sword-move-input/sword-move-input.component';
import {BeastBlueprintInputComponent} from './features/input/beast-blueprint-input/beast-blueprint-input.component';
import {RaceInputComponent} from './features/input/race-input/race-input.component';
import {WeaponBlueprintInputComponent} from './features/input/weapon-blueprint-input/weapon-blueprint-input.component';
import {ArmorBlueprintInputComponent} from './features/input/armor-blueprint-input/armor-blueprint-input.component';
import {TreasureBlueprintInputComponent} from './features/input/treasure-blueprint-input/treasure-blueprint-input.component';
import {GoodsBlueprintInputComponent} from './features/input/goods-blueprint-input/goods-blueprint-input.component';
import {PersonBlueprintInputComponent} from './features/input/person-blueprint-input/person-blueprint-input.component';

const appRoutes: Routes = [
  {path: 'generator', component: GeneratorComponent},
  {path: 'calculator', component: CalculatorComponent},
  {path: 'battleground', component: BattlegroundComponent},
  {path: 'shop', component: ShopComponent},
  {
    path: 'inputs', component: InputComponent, children: [
      {path: 'weapon', component: WeaponBlueprintInputComponent},
      {path: 'armor', component: ArmorBlueprintInputComponent},
      {path: 'treasure', component: TreasureBlueprintInputComponent},
      {path: 'goods', component: GoodsBlueprintInputComponent},
      {path: 'person', component: PersonBlueprintInputComponent},
      {path: 'beast', component: BeastBlueprintInputComponent},
      {path: 'race', component: RaceInputComponent},
      {path: 'skill', component: SkillInputComponent},
      {path: 'spell', component: SpellInputComponent},
      {path: 'sword-move', component: SwordMoveInputComponent}
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
